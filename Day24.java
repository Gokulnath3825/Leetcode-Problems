import java.util.*;

public class Day24 {

    static void dfs(int node, List<List<Integer>> graph, boolean[] suspicious) {
        suspicious[node] = true;

        for (int next : graph.get(node)) {
            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }

    static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious);

        // Check if any non-suspicious method calls a suspicious method
        for (int[] edge : invocations) {
            if (!suspicious[edge[0]] && suspicious[edge[1]]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // Return all non-suspicious methods
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        int[][] invocations = new int[m][2];

        for (int i = 0; i < m; i++) {
            invocations[i][0] = sc.nextInt();
            invocations[i][1] = sc.nextInt();
        }

        List<Integer> result = remainingMethods(n, k, invocations);

        // Output
        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}