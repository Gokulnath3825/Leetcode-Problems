import java.util.*;

public class Day05 {

    public static String smallestSubsequence(String s) {

        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            int index = current - 'a';

            if (visited[index]) {
                continue;
            }

            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > current &&
                   last[stack.charAt(stack.length() - 1) - 'a'] > i) {

                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                visited[removed - 'a'] = false;
            }

            stack.append(current);
            visited[index] = true;
        }

        return stack.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(smallestSubsequence(s));
    }
}