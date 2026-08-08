import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }
        int bits = 0;
        int x = n;
        while (x > 0) {
            bits++;
            x >>= 1;
        }
        return 1 << bits;
    }
}
public class Day11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();
        // Input array
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.uniqueXorTriplets(nums));

        sc.close();
    }
}