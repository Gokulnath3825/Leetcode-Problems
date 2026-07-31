import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        for (int start = 1; start <= 9; start++) {

            int num = 0;

            for (int digit = start; digit <= 9; digit++) {

                num = num * 10 + digit;

                if (num >= low && num <= high)
                    ans.add(num);

                if (num > high)
                    break;
            }
        }

        Collections.sort(ans);
        return ans;
    }
}

public class Day08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = sc.nextInt();
        int high = sc.nextInt();

        Solution obj = new Solution();
        List<Integer> ans = obj.sequentialDigits(low, high);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}