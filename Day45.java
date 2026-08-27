import java.util.*;

public class Day45 {

    public static String shortestBeautifulSubstring(String s, int k) {

        List<Integer> ones = new ArrayList<>();

        // Store positions of all 1s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        // Not enough 1s
        if (ones.size() < k) {
            return "";
        }

        String ans = null;

        for (int i = 0; i + k - 1 < ones.size(); i++) {

            int start = ones.get(i);
            int end = ones.get(i + k - 1);

            String cur = s.substring(start, end + 1);

            if (ans == null ||
                cur.length() < ans.length() ||
                (cur.length() == ans.length() && cur.compareTo(ans) < 0)) {

                ans = cur;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int k = sc.nextInt();

        System.out.println(shortestBeautifulSubstring(s, k));
    }
}