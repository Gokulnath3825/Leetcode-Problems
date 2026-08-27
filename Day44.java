import java.util.*;

public class Day44 {

    public static int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int x = k;

        while (set.contains(x)) {
            x += k;
        }

        return x;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(missingMultiple(nums, k));
    }
}