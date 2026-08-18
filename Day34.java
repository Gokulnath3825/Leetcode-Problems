import java.util.*;

public class Day34 {

    public static int longestSubsequence(int[] nums) {

        int xor = 0;
        boolean nonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                nonZero = true;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        return nonZero ? nums.length - 1 : 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        // Input array
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call function
        int result = longestSubsequence(nums);

        // Output
        System.out.println(result);

        sc.close();
    }
}