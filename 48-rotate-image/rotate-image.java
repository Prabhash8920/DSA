class Solution {
    static void findtranspose(int[][] matrix){
        int n= matrix.length;
        for(int i=0; i<n; i++){ 
            for(int j=i;j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =temp;
            }
        }
    }
    static void reverse(int[]arr){
        int i =0; 
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        
        findtranspose(matrix);
        for(int i=0; i<matrix.length; i++){
        reverse(matrix[i]);
        }

    }
}