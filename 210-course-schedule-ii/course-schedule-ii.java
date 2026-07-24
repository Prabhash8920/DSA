class Solution {
    public int[] findOrder(int n, int[][] pre) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[n];

        for (int i = 0; i < pre.length; i++) {
            int a = pre[i][0];
            int b = pre[i][1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);

            for (int next : adj.get(front)) {
                indegree[next]--;

                if (indegree[next] == 0)
                    q.offer(next);
            }
        }

        if (ans.size() != n)
            return new int[0];

        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = ans.get(i);

        return res;
    }
}