import java.util.*;

class Solution {
    public int minimumPushes(String word) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies
        Arrays.sort(freq);

        int ans = 0;
        int pos = 0;

        // Assign highest frequencies to minimum pushes
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0)
                break;

            ans += freq[i] * (pos / 8 + 1);
            pos++;
        }

        return ans;
    }
}

public class Day19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input word
        String word = sc.next();

        Solution obj = new Solution();
        System.out.println(obj.minimumPushes(word));

        sc.close();
    }
}
