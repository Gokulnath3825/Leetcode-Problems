import java.util.*;

class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                dp[i][j] = Math.max(
                    piles[i] - dp[i + 1][j],
                    piles[j] - dp[i][j - 1]
                );
            }
        }

        return dp[0][n - 1] > 0;
    }
}

public class Day21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] piles = new int[n];

        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.stoneGame(piles));

        sc.close();
    }
}