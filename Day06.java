import java.util.*;

public class Day06 {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;

        int n = grid[0].length;

        int total = m * n;

        k %= total;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            result.add(new ArrayList<>());

            for (int j = 0; j < n; j++) {

                result.get(i).add(0);

            }
        }
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                int oldIndex = i * n + j;
                int newIndex = (oldIndex + k) % total;
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                result.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        List<List<Integer>> ans = shiftGrid(grid, k);
        for (List<Integer> row : ans) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
