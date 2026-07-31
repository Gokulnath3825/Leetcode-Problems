import java.util.*;

class Solution {
    public int maxProduct(int n) {
        int first = 0;
        int second = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit > first) {
                second = first;
                first = digit;
            } else if (digit > second) {
                second = digit;
            }

            n /= 10;
        }

        return first * second;
    }
}

public class Day13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        int n = sc.nextInt();

        Solution obj = new Solution();
        System.out.println(obj.maxProduct(n));

        sc.close();
    }
}