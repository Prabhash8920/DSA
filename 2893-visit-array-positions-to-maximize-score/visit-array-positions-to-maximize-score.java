
class Solution {

    long[][] dp;

    private long find(int i, int[] nums, int x, int f) {

        if (i < 0)
            return 0L;

        if (dp[i][f] != -1)
            return dp[i][f];

        long val = nums[i];

        // Same parity
        if ((nums[i] % 2 == 1 && f == 1) ||
            (nums[i] % 2 == 0 && f == 0)) {


            val += find(i - 1, nums, x, f);
        }
        else {

            // Skip current element
            long cur = find(i - 1, nums, x, f);

            // Take current element and change parity
            val = Math.max(
                    cur,
                    val + find(i - 1, nums, x, 1 - f) - x
                  );
        }

        return dp[i][f] = val;
    }

    public long maxScore(int[] nums, int x) {

        int n = nums.length;

        dp = new long[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        // Reverse array
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int f = (nums[n - 1] % 2 == 1) ? 1 : 0;

        return find(n - 1, nums, x, f);
    }
}
    
