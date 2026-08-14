class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int maxLeft = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int j = k; j < nums.length; j++) {
            // i = j-k becomes newly eligible
            maxLeft = Math.max(maxLeft, nums[j - k]);

            // Best nums[i] + nums[j]
            ans = Math.max(ans, maxLeft + nums[j]);
        }

        return ans;
      
    }
}