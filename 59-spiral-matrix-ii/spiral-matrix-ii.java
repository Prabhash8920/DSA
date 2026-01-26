class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int toprow=0, bottomrow=n-1, leftcol=0 ,rightcol=n-1;
        int curr =1;
        while(curr<=n*n){
             //toprow=> left col to right col
            for(int j=leftcol; j<=rightcol &&curr<=n*n; j++){
                matrix[toprow][j]=curr++;
               
            }
            toprow++;
            // rightcol=> toprow to bottomrow
            for(int i=toprow; i<=bottomrow && curr<=n*n; i++){
                matrix[i][rightcol]=curr++;
                
            }
            rightcol--;
            // bottomrow => rightcol to leftcol
            for(int j=rightcol; j>=leftcol && curr<=n*n; j--){
                matrix[bottomrow][j]=curr++;
            }
            bottomrow--;
            // leftcol = bottomrow to toprow
            for(int i= bottomrow;i>=toprow && curr<=n*n ; i--){
                matrix[i][leftcol]=curr++;
                
            }
            leftcol++;
        }
        return matrix;
    
        
    }
}