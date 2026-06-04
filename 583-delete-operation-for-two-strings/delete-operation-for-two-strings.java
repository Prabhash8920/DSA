class Solution {

    public int lcs(int i, int j, String a, String b, int[][] dp) {

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + lcs(i - 1, j - 1, a, b, dp);
        }

        return dp[i][j] = Math.max(
                lcs(i - 1, j, a, b, dp),
                lcs(i, j - 1, a, b, dp)
        );
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return lcs(m - 1, n - 1, text1, text2, dp);
    }

    public int minDistance(String word1, String word2) {

        int lcsLen = longestCommonSubsequence(word1, word2);

        return word1.length() + word2.length() - 2 * lcsLen;
    }
}