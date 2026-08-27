import java.util.Scanner;

public class Day43 {

    public static int stoneGameVIII(int[] stones) {

        int n = stones.length;

        // Prefix sum
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        int ans = stones[n - 1];

        // Find maximum score difference
        for (int i = n - 2; i > 0; i--) {
            ans = Math.max(ans, stones[i] - ans);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stones = new int[n];

        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }

        System.out.println(stoneGameVIII(stones));
    }
}