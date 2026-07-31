import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] pairXor = new boolean[MAX];
        boolean[] ans = new boolean[MAX];

        int n = nums.length;

        // Compute XOR of all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        // Compute XOR of pair XOR with each element
        for (int x = 0; x < MAX; x++) {
            if (!pairXor[x]) continue;

            for (int num : nums) {
                ans[x ^ num] = true;
            }
        }

        int count = 0;
        for (boolean val : ans) {
            if (val) {
                count++;
            }
        }

        return count;
    }
}

public class Day12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array size
        int n = sc.nextInt();

        // Read array elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int result = obj.uniqueXorTriplets(nums);

        System.out.println(result);

        sc.close();
    }
}