import java.util.*;

public class Day42 {

    public static boolean sumGame(String num) {

        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        // Left half
        for (int i = 0; i < n / 2; i++) {

            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        // Right half
        for (int i = n / 2; i < n; i++) {

            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        // Odd number of '?' -> Alice wins
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        int diff = leftSum - rightSum;

        int qDiff = rightQ - leftQ;

        return diff != 9 * qDiff / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String num = sc.next();

        System.out.println(sumGame(num));
    }
}