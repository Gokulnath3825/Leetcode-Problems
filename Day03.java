import java.util.*;

public class Day03 {

    public static int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] divisible = new long[max + 1];

        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                divisible[g] += freq[multiple];
            }
        }

        long[] exact = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long cnt = divisible[g];
            exact[g] = cnt * (cnt - 1) / 2;

            for (int multiple = g * 2; multiple <= max; multiple += g) {
                exact[g] -= exact[multiple];
            }
        }

        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long k = queries[i] + 1;

            int lo = 1, hi = max;

            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (prefix[mid] >= k)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            ans[i] = lo;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int q = sc.nextInt();

        long[] queries = new long[q];
        for (int i = 0; i < q; i++)
            queries[i] = sc.nextLong();

        int[] ans = gcdValues(nums, queries);

        for (int x : ans)
            System.out.print(x + " ");
    }
}