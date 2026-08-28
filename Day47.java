import java.util.*;

public class Day47 {

    static String solve(String s, String target) {

        int n = s.length();

        // Count characters
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Check palindrome possibility
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Characters for left half
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = count[i] / 2;
        }

        int halfLen = n / 2;

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {

            boolean found = false;

            // Try smallest character
            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) {
                    continue;
                }

                // Choose character
                half[c]--;
                left.append((char) ('a' + c));

                // Complete remaining half with largest characters
                StringBuilder temp = new StringBuilder(left);

                for (int x = 25; x >= 0; x--) {
                    for (int k = 0; k < half[x]; k++) {
                        temp.append((char) ('a' + x));
                    }
                }

                // Create palindrome
                StringBuilder candidate = new StringBuilder(temp);

                if (n % 2 == 1) {
                    candidate.append(middle);
                }

                for (int i = temp.length() - 1; i >= 0; i--) {
                    candidate.append(temp.charAt(i));
                }

                // Check candidate > target
                if (candidate.toString().compareTo(target) > 0) {
                    found = true;
                    break;
                }

                // Undo
                left.deleteCharAt(left.length() - 1);
                half[c]++;
            }

            if (!found) {
                return "";
            }
        }

        // Build final palindrome
        StringBuilder answer = new StringBuilder(left);

        if (n % 2 == 1) {
            answer.append(middle);
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            answer.append(left.charAt(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String target = sc.next();

        String result = solve(s, target);

        if (result.equals("")) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }

        sc.close();
    }
}