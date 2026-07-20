class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int row = grid.length;
        int cols = grid[0].length;

        int n = row * cols;
        k %= n;

        reverse(grid, 0, n - 1, cols);
        reverse(grid, 0, k - 1, cols);
        reverse(grid, k, n - 1, cols);

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] r : grid) {
            List<Integer> list = new ArrayList<>();
            for (int x : r) {
                list.add(x);
            }
            ans.add(list);
        }

        return ans;
    }   // <-- This closing brace was missing

    private void reverse(int[][] grid, int left, int right, int cols) {

        while (left < right) {

            int r1 = left / cols;
            int c1 = left % cols;

            int r2 = right / cols;
            int c2 = right % cols;

            int temp = grid[r1][c1];
            grid[r1][c1] = grid[r2][c2];
            grid[r2][c2] = temp;

            left++;
            right--;
        }
    }
}