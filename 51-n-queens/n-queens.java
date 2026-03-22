class Solution {

    private void nqueen(char[][] board, int row, List<List<String>> ans){
        int n = board.length;

        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nqueen(board, row + 1, ans);
                board[row][j] = '.'; // backtracking
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        int n = board.length;

        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q') return false;
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        nqueen(board, 0, ans);

        return ans;
    }
}
