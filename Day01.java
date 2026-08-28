import java.util.*;
public class Day01 {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oddSum = n * n;
        int evenSum = n * (n + 1);
        System.out.println(gcd(oddSum, evenSum));
        sc.close();
    }
}
