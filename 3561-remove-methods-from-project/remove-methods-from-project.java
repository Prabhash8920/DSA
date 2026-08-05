import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // O(V + E)

        // Adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        boolean[] suspicious = new boolean[n];

        // Build graph
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;

                if (!suspicious[neighbor]) {
                    queue.offer(neighbor);
                    suspicious[neighbor] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean cannotRemove = false;

        for (int i = 0; i < n; i++) {
            if (suspicious[i] && inDegree[i] > 0) {
                cannotRemove = true;
                break;
            }

            if (!suspicious[i]) {
                result.add(i);
            }
        }

        if (cannotRemove) {
            List<Integer> allMethods = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                allMethods.add(i);
            }
            return allMethods;
        }

        return result;
    }
}