import java.util.*;

public class Day36 {

    public static int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        int[] prefix = new int[n + 1];

        // Prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];

        // Length of subarray
        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;

                // Try every split
                for (int k = l; k < r; k++) {

                    int leftSum = prefix[k + 1] - prefix[l];
                    int rightSum = prefix[r + 1] - prefix[k + 1];

                    if (leftSum < rightSum) {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][k]
                        );

                    } else if (leftSum > rightSum) {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[k + 1][r]
                        );

                    } else {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + Math.max(
                                dp[l][k],
                                dp[k + 1][r]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of stones
        int n = sc.nextInt();

        int[] stoneValue = new int[n];

        // Array input
        for (int i = 0; i < n; i++) {
            stoneValue[i] = sc.nextInt();
        }

        // Call function
        int result = stoneGameV(stoneValue);

        // Print answer
        System.out.println(result);

        sc.close();
    }
}