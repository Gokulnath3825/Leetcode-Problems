import java.util.*;

public class Day37 {

    public static int largestInteger(int[] nums, int k) {

        int n = nums.length;
        int[] freq = new int[51];

        // Count frequency
        for (int num : nums) {
            freq[num]++;
        }

        // If k == n
        if (k == n) {
            int ans = 0;

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        // If k == 1
        if (k == 1) {
            int ans = -1;

            for (int num = 0; num <= 50; num++) {
                if (freq[num] == 1) {
                    ans = num;
                }
            }

            return ans;
        }

        // 1 < k < n
        int ans = -1;

        // Check first element
        if (freq[nums[0]] == 1) {
            ans = Math.max(ans, nums[0]);
        }

        // Check last element
        if (freq[nums[n - 1]] == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input n
        int n = sc.nextInt();

        // Input array
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input k
        int k = sc.nextInt();

        // Call function
        int result = largestInteger(nums, k);

        // Output
        System.out.println(result);

        sc.close();
    }
}