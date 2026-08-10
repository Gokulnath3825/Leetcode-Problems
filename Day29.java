import java.util.*;

public class Day29 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(dp[n]);
    }
}