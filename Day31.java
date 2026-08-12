import java.util.*;

public class Day31 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < n; right++) {

            map.put(nums[right],
                map.getOrDefault(nums[right], 0) + 1);

            while (map.get(nums[right]) > k) {
                map.put(nums[left],
                    map.get(nums[left]) - 1);
                left++;
            }

            int length = right - left + 1;

            max = Math.max(max, length);
        }

        System.out.println(max);
    }
}