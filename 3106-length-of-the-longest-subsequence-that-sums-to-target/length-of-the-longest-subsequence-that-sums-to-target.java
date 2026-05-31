class Solution {

    int[][] dp;

    private int subset(int i, List<Integer> nums, int target) {

        if (target == 0) return 0;

        if (i == nums.size()) return -1000000;

        if (dp[i][target] != -1) return dp[i][target];

        int skip = subset(i + 1, nums, target);

        int pick = -1000000;

        if (target >= nums.get(i)) {
            pick = 1 + subset(i + 1, nums, target - nums.get(i));
        }

        return dp[i][target] = Math.max(skip, pick);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int n = nums.size();

        dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = subset(0, nums, target);

        return ans < 0 ? -1 : ans;
    }
}