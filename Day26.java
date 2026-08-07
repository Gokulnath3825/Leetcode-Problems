import java.util.*;

public class Day26 {

    public static String smallestNumber(String num, long t) {

        int[] need = new int[4];
        int[] primes = {2, 3, 5, 7};

        // Factorize t
        for (int i = 0; i < 4; i++) {

            while (t % primes[i] == 0) {
                need[i]++;
                t /= primes[i];
            }
        }

        // If another prime factor exists
        if (t > 1) {
            return "-1";
        }

        int n = num.length();

        // Prefix prime-factor counts
        int[][] prefix = new int[n + 1][4];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < 4; j++) {
                prefix[i + 1][j] = prefix[i][j];
            }

            char ch = num.charAt(i);

            if (ch != '0') {
                addFactors(prefix[i + 1], ch - '0');
            }
        }

        // num itself
        if (num.indexOf('0') == -1 &&
                valid(prefix[n], need)) {

            return num;
        }

        // Change from right to left
        for (int i = n - 1; i >= 0; i--) {

            if (num.charAt(i) == '0') {
                continue;
            }

            int[] current = prefix[i].clone();

            int oldDigit = num.charAt(i) - '0';

            for (int digit = oldDigit + 1;
                 digit <= 9;
                 digit++) {

                int[] temp = current.clone();

                addFactors(temp, digit);

                int remaining = n - i - 1;

                String suffix =
                        buildSmallestSuffix(
                                temp,
                                need,
                                remaining
                        );

                if (suffix != null) {

                    StringBuilder ans =
                            new StringBuilder();

                    ans.append(num.substring(0, i));
                    ans.append(digit);
                    ans.append(suffix);

                    return ans.toString();
                }
            }
        }

        // Need n + 1 digits
        String answer =
                buildSmallestSuffix(
                        new int[4],
                        need,
                        n + 1
                );

        return answer == null ? "-1" : answer;
    }

    // Add factors of digit
    static void addFactors(int[] count, int digit) {

        while (digit % 2 == 0) {
            count[0]++;
            digit /= 2;
        }

        while (digit % 3 == 0) {
            count[1]++;
            digit /= 3;
        }

        while (digit % 5 == 0) {
            count[2]++;
            digit /= 5;
        }

        while (digit % 7 == 0) {
            count[3]++;
            digit /= 7;
        }
    }

    // Check requirement
    static boolean valid(int[] have, int[] need) {

        for (int i = 0; i < 4; i++) {

            if (have[i] < need[i]) {
                return false;
            }
        }

        return true;
    }

    // Build smallest suffix
    static String buildSmallestSuffix(
            int[] have,
            int[] need,
            int length) {

        int[] missing = new int[4];

        for (int i = 0; i < 4; i++) {
            missing[i] =
                    Math.max(0, need[i] - have[i]);
        }

        int[] digits = new int[length];
        int count = 0;

        // 2^3 = 8
        while (missing[0] >= 3) {

            if (count == length)
                return null;

            digits[count++] = 8;
            missing[0] -= 3;
        }

        // 3^2 = 9
        while (missing[1] >= 2) {

            if (count == length)
                return null;

            digits[count++] = 9;
            missing[1] -= 2;
        }

        // 2 * 3 = 6
        while (missing[0] >= 1 &&
               missing[1] >= 1) {

            if (count == length)
                return null;

            digits[count++] = 6;

            missing[0]--;
            missing[1]--;
        }

        // 2^2 = 4
        while (missing[0] >= 2) {

            if (count == length)
                return null;

            digits[count++] = 4;
            missing[0] -= 2;
        }

        // Remaining 2
        while (missing[0] > 0) {

            if (count == length)
                return null;

            digits[count++] = 2;
            missing[0]--;
        }

        // Remaining 3
        while (missing[1] > 0) {

            if (count == length)
                return null;

            digits[count++] = 3;
            missing[1]--;
        }

        // Remaining 5
        while (missing[2] > 0) {

            if (count == length)
                return null;

            digits[count++] = 5;
            missing[2]--;
        }

        // Remaining 7
        while (missing[3] > 0) {

            if (count == length)
                return null;

            digits[count++] = 7;
            missing[3]--;
        }

        Arrays.sort(digits, 0, count);

        StringBuilder result =
                new StringBuilder();

        // Fill remaining positions with 1
        for (int i = count; i < length; i++) {
            result.append('1');
        }

        // Add required digits
        for (int i = 0; i < count; i++) {
            result.append(digits[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String num = "10";
        long t = 320;

        String result = smallestNumber(num, t);

        System.out.println("num = " + num);
        System.out.println("t = " + t);
        System.out.println("Answer = " + result);
    }
}