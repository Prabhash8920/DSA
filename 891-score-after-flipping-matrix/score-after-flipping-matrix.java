class Solution {
    public int matrixScore(int[][] grid) {
        // 0th col of matrix should have all ones
        int m = grid.length;
        int n= grid[0].length;
        for(int i=0; i<m; i++) {
            if(grid[i][0]==0){ // flip that row 
            for(int j=0; j<n; j++){
                grid[i][j] ^= 1;

            }

            }
        }
          // har us col ko flip karo jisme no of 0 > no of 1
          for(int j=0; j<n; j++){
            int zeroes =0 , ones=0 ;
            for(int i=0; i<m; i++){
                if(grid[i][j]==0) zeroes++;
                else ones++;
            }
            if(zeroes>ones){ // flip that col
            for(int i=0; i<m; i++){
                grid[i][j] ^= 1;
            }

            }
          }
          int sum =0;
          int pow =1;
          for(int j=n-1; j>=0; j--){
            int ones =0;
            for(int i=0; i<m; i++){
                if(grid[i][j]==1) ones++;
            }
            sum += pow*ones;
            pow *= 2;
          }
          return sum;

    }
}