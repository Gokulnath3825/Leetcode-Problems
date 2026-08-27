import java.util.*;

public class Day41 {

    public static boolean checkDivisibility(int n) {

        int temp = n;
        int sum = 0;
        int product = 1;

        while (temp > 0) {
            int digit = temp % 10;

            sum += digit;
            product *= digit;

            temp /= 10;
        }

        int total = sum + product;

        return n % total == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(checkDivisibility(n));
    }
}