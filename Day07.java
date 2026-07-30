import java.util.*;

public class Day07 {

    public static int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        int previousZeroBlock = Integer.MIN_VALUE;
        int maxGain = 0;

        int i = 0;

        while (i < s.length()) {

            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int length = j - i;

            if (s.charAt(i) == '1') {
                ones += length;
            } else {
                maxGain = Math.max(maxGain, previousZeroBlock + length);
                previousZeroBlock = length;
            }

            i = j;
        }

        return ones + maxGain;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(maxActiveSectionsAfterTrade(s));
    }
}