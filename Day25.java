import java.util.Scanner;

public class Day25 {

    public static int digitProduct(int num) {
        int product = 1;

        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }

        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        while (true) {
            if (digitProduct(n) % t == 0) {
                System.out.println(n);
                break;
            }
            n++;
        }

        sc.close();
    }
}