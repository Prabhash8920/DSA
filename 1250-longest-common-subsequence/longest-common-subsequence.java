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
      

    
   

    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int m = a.length();
        int n = b.length();
       int [][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            int p = (i>=1&& j>=1)? dp[i-1][j-1] :0;
            int q = (j>=1) ? dp[i][j-1]:0;
            int r = (i>=1)? dp[i-1][j]:0;
            if(a.charAt(i)==b.charAt(j)){
                dp[i][j]= 1+ p;
                
            }
            else{
                dp[i][j] = Math.max(q,r);
            }
            }
        }

        return dp[m-1][n-1];
    }
}