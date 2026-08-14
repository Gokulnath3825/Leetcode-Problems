import java.util.*;

public class Day33 {

    public static int maximumLengthSubstring(String s) {

        int[] cnt = new int[26];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            cnt[s.charAt(right) - 'a']++;

            while (cnt[s.charAt(right) - 'a'] > 2) {
                cnt[s.charAt(left) - 'a']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(maximumLengthSubstring(s));

        sc.close();
    }
}