class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int n = intervals.length;
        boolean[] covered = new boolean[n];

        for (int i = 0; i < n; i++) {

            int l = intervals[i][0];
            int r = intervals[i][1];

            for (int j = 0; j < n; j++) {

                if (i == j) continue;

                int m = intervals[j][0];
                int k = intervals[j][1];

                if (m <= l && r <= k) {
                    if (m != l || k != r) {
                        covered[i] = true;
                        break;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!covered[i]) ans++;
        }

        return ans;
    }
}