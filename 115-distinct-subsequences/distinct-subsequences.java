class Solution {

    public long solve(int i, int j, String s, String t, long[][] dp) {

        if (j < 0)
            return 1;

        if (i < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {

            long pick = solve(i - 1, j - 1, s, t, dp);
            long skip = solve(i - 1, j, s, t, dp);

            return dp[i][j] = pick + skip;
        }

        return dp[i][j] = solve(i - 1, j, s, t, dp);
    }

    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        long[][] dp = new long[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return (int) solve(m - 1, n - 1, s, t, dp);
    }
}