import java.util.*;

class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        String mid = "";

        // Build first half and middle character
        for (int i = 0; i < 26; i++) {

            while (freq[i] >= 2) {
                firstHalf.append((char) ('a' + i));
                freq[i] -= 2;
            }

            if (freq[i] == 1 && mid.isEmpty()) {
                mid = String.valueOf((char) ('a' + i));
            }
        }

        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        return firstHalf.toString() + mid + secondHalf;
    }
}

public class Day16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input string
        String s = sc.next();

        Solution obj = new Solution();
        String result = obj.smallestPalindrome(s);

        System.out.println(result);

        sc.close();
    }
}