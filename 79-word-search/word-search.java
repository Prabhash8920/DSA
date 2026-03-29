class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(i, j, 0, board, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int idx, char[][] board, String word, boolean[][] visited) {
        if(idx == word.length()) return true;

        // boundary + checks
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
           visited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }

        visited[i][j] = true;

        // explore 4 directions
        boolean found = dfs(i+1, j, idx+1, board, word, visited) ||
                        dfs(i-1, j, idx+1, board, word, visited) ||
                        dfs(i, j+1, idx+1, board, word, visited) ||
                        dfs(i, j-1, idx+1, board, word, visited);

        visited[i][j] = false; // backtrack

        return found;
    }
}