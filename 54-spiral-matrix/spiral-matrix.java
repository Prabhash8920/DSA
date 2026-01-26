class Solution {
    public List<Integer> spiralOrder(int[][] matrix ) {
         List<Integer> res = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;


        int toprow=0 ,bottomrow=m-1 ,leftcol=0 , rightcol=n-1;
        int totalElements=0;
        while(totalElements<m*n){
            //toprow=> left col to right col
            for(int j=leftcol; j<=rightcol && totalElements<m*n; j++){
                res.add(matrix[toprow][j]);
                totalElements++;
            }
            toprow++;
            // rightcol=> toprow to bottomrow
            for(int i=toprow; i<=bottomrow && totalElements<m*n; i++){
                res.add(matrix[i][rightcol]);
                totalElements++;
            }
            rightcol--;
            // bottomrow => rightcol to leftcol
            for(int j=rightcol; j>=leftcol && totalElements<m*n; j--){
                res.add(matrix[bottomrow][j]);
                totalElements++;
            }
            bottomrow--;
            // leftcol = bottomrow to toprow
            for(int i= bottomrow;i>=toprow && totalElements<m*n; i--){
                res.add(matrix[i][leftcol]);
                totalElements++;
            }
            leftcol++;
        }
        return res;

    }
}