class Solution {

    int[][] dp;

    private int maxDiff(int[] nums, int l, int r) {

        if (l == r)
            return nums[l];

        if (dp[l][r] != Integer.MIN_VALUE)
            return dp[l][r];

        int takeLeft = nums[l] - maxDiff(nums, l + 1, r);
        int takeRight = nums[r] - maxDiff(nums, l, r - 1);

        return dp[l][r] = Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return maxDiff(nums, 0, n - 1) >= 0;
    }
}