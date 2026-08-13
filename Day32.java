import java.util.*;

public class Day32 {

    static int[] leftChar;
    static int[] rightChar;
    static int[] leftCount;
    static int[] rightCount;
    static int[] max;
    static int[] length;

    static void build(int node, int start, int end, char[] arr) {

        length[node] = end - start + 1;

        if (start == end) {
            leftChar[node] = arr[start];
            rightChar[node] = arr[start];
            leftCount[node] = 1;
            rightCount[node] = 1;
            max[node] = 1;
            return;
        }

        int mid = (start + end) / 2;

        build(node * 2, start, mid, arr);
        build(node * 2 + 1, mid + 1, end, arr);

        merge(node);
    }

    static void update(int node, int start, int end,
                       int index, char ch) {

        if (start == end) {
            leftChar[node] = ch;
            rightChar[node] = ch;
            leftCount[node] = 1;
            rightCount[node] = 1;
            max[node] = 1;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, end, index, ch);
        }

        merge(node);
    }

    static void merge(int node) {

        int left = node * 2;
        int right = node * 2 + 1;

        leftChar[node] = leftChar[left];
        rightChar[node] = rightChar[right];

        leftCount[node] = leftCount[left];
        rightCount[node] = rightCount[right];

        max[node] = Math.max(max[left], max[right]);

        length[node] = length[left] + length[right];

        if (rightChar[left] == leftChar[right]) {

            max[node] = Math.max(
                    max[node],
                    rightCount[left] + leftCount[right]
            );

            if (leftCount[left] == length[left]) {
                leftCount[node] =
                        length[left] + leftCount[right];
            }

            if (rightCount[right] == length[right]) {
                rightCount[node] =
                        rightCount[left] + length[right];
            }
        }
    }

    static int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        leftChar = new int[4 * n];
        rightChar = new int[4 * n];
        leftCount = new int[4 * n];
        rightCount = new int[4 * n];
        max = new int[4 * n];
        length = new int[4 * n];

        char[] arr = s.toCharArray();

        build(1, 0, n - 1, arr);

        int[] answer = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            update(
                    1,
                    0,
                    n - 1,
                    queryIndices[i],
                    queryCharacters.charAt(i)
            );

            answer[i] = max[1];
        }

        return answer;
    }

    public static void main(String[] args) {

        String s = "babacc";
        String queryCharacters = "bcb";

        int[] queryIndices = {1, 3, 3};

        int[] answer = longestRepeating(
                s,
                queryCharacters,
                queryIndices
        );

        System.out.println(Arrays.toString(answer));
    }
}