import java.util.*;

public class Day38 {

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Rows with no reserved seats can have 2 families
        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

            // Seats 2,3,4,5
            boolean left = (mask & (1 << 2)) == 0
                    && (mask & (1 << 3)) == 0
                    && (mask & (1 << 4)) == 0
                    && (mask & (1 << 5)) == 0;

            // Seats 4,5,6,7
            boolean middle = (mask & (1 << 4)) == 0
                    && (mask & (1 << 5)) == 0
                    && (mask & (1 << 6)) == 0
                    && (mask & (1 << 7)) == 0;

            // Seats 6,7,8,9
            boolean right = (mask & (1 << 6)) == 0
                    && (mask & (1 << 7)) == 0
                    && (mask & (1 << 8)) == 0
                    && (mask & (1 << 9)) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] reservedSeats = {
            {1, 2},
            {1, 3},
            {1, 8},
            {2, 6},
            {2, 7}
        };

        int result = maxNumberOfFamilies(n, reservedSeats);

        System.out.println(result);
    }
}