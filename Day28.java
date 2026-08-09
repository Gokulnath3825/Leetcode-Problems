import java.util.*;

public class Day28 {

    static int n;
    static int[] suffix;
    static int[][] dp;

    public static int stoneGameII(int[] piles) {

        n = piles.length;

        suffix = new int[n];

        suffix[n - 1] = piles[n - 1];

        // Suffix sum
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        dp = new int[n][n + 1];

        // Fill with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 1);
    }

    static int solve(int i, int M) {

        // No piles remaining
        if (i >= n) {
            return 0;
        }

        // Can take all remaining piles
        if (i + 2 * M >= n) {
            return suffix[i];
        }

        // Already calculated
        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int best = 0;

        // Try taking 1 to 2*M piles
        for (int X = 1; X <= 2 * M; X++) {

            int opponent = solve(
                i + X,
                Math.max(M, X)
            );

            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        dp[i][M] = best;

        return best;
    }

    public static void main(String[] args) {

        int[] piles = {2, 7, 9, 4, 4};

        int result = stoneGameII(piles);

        System.out.println("Answer: " + result);
    }
}