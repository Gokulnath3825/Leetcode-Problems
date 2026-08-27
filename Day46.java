import java.util.*;

public class Day46 {

    public static String lexGreaterPermutation(String s, String target) {

        int[] count = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        // Try to match target
        for (int i = 0; i < target.length(); i++) {

            int t = target.charAt(i) - 'a';

            if (count[t] > 0) {

                count[t]--;
                prefix.append(target.charAt(i));

            } else {

                // Find smallest character greater than target[i]
                for (int j = t + 1; j < 26; j++) {

                    if (count[j] > 0) {

                        prefix.append((char) ('a' + j));
                        count[j]--;

                        // Add remaining characters in sorted order
                        for (int k = 0; k < 26; k++) {
                            while (count[k] > 0) {
                                prefix.append((char) ('a' + k));
                                count[k]--;
                            }
                        }

                        return prefix.toString();
                    }
                }

                break;
            }
        }

        // Backtrack
        for (int i = prefix.length() - 1; i >= 0; i--) {

            int current = prefix.charAt(i) - 'a';

            count[current]++;

            // Try a bigger character
            for (int j = current + 1; j < 26; j++) {

                if (count[j] > 0) {

                    StringBuilder ans =
                        new StringBuilder(prefix.substring(0, i));

                    ans.append((char) ('a' + j));
                    count[j]--;

                    // Add remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String target = sc.next();

        System.out.println(lexGreaterPermutation(s, target));
    }
}