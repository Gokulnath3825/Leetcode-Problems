import java.util.*;

public class Day30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int sum = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Store all elements
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Find smallest missing integer
        while (set.contains(sum)) {
            sum++;
        }

        System.out.println(sum);
    }
}