class Solution {
    // RECURSION RULE - T.C = 2^m+m
//    public int uniquePaths(int m , int n){
//     return paths(0,0,m,n);

//    }
//    private int paths(int row , int col, int m , int n ){
//     if(row>=m || col>=n) return 0;
//     if(row==m-1 && col==n-1) return 1;
//     int rightways = paths(row,col+1,m,n);
//     int downways = paths(row+1, col,m,n);
//     return rightways + downways;

// RECURSION + MEMOIZATION - T.C - O(m*n) and A.S- O(m*n)
//    public int uniquePaths(int m , int n){
//     int [][] dp = new int[m][n];
//     for(int i =0; i<m; i++){
//         for(int j =0; j<n; j++){
//             dp[i][j] = -1;
//         }
//     }
//     return paths(0,0,m,n,dp);

//    }
//    private int paths(int row , int col, int m , int n, int[][] dp ){
//     if(row>=m || col>=n) return 0;
//     if(row==m-1 && col==n-1) return 1;
//     if(dp[row][col]!=-1) return dp[row][col];
//     int rightways = paths(row,col+1,m,n,dp);
//     int downways = paths(row+1, col,m,n,dp);
//     return dp[row][col] = rightways + downways;

// TABULATION METHOD
 public int uniquePaths(int m , int n){
    int [][] dp = new int[m][n];
    for(int i =0; i<m; i++){
        for(int j=0; j<n; j++){
            if(i==0 || j==0 )  dp[i][j]=1;
            else dp[i][j] = dp[i][j-1] + dp[i-1][j];
        }
    }
    return dp[m-1][n-1];
}
}