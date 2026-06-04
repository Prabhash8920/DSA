class Solution {
    // simple recursion way but TLE error is coming
    // public int longestCommonSubsequence(String a, String b) {
       // int m = a.length() , n = b.length();
        // if(m==0 || n==0) return 0;
        // String a2 = a.substring(0,m-1);
        // String b2 = b.substring(0,n-1);

        // if(a.charAt(m-1)==b.charAt(n-1)){
        //     return 1 + longestCommonSubsequence(a2,b2);
        // } else{
        //     return  Math.max(longestCommonSubsequence(a,b2),longestCommonSubsequence(a2,b)); 
        // }


        // using stringbuilder
      

    int[][] dp;

    public int lcs(int i, int j, String a, String b) {

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + lcs(i - 1, j - 1, a, b);
        }

        return dp[i][j] = Math.max(
                lcs(i - 1, j, a, b),
                lcs(i, j - 1, a, b)
        );
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return lcs(m - 1, n - 1, text1, text2);
    }
}