class Solution {

    public int coinCount(int i, int[] coins, int amount, long[][] dp) {

        if (amount == 0)
            return 1;

        if (i == coins.length)
            return 0;

        if (dp[i][amount] != -1)
            return (int) dp[i][amount];

        int skip = coinCount(i + 1, coins, amount, dp);

        int pick = 0;
        if (amount >= coins[i])
            pick = coinCount(i, coins, amount - coins[i], dp);

        return (int) (dp[i][amount] = skip + pick);
    }

    public int change(int amount, int[] coins) {

        long[][] dp = new long[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return coinCount(0, coins, amount, dp);
    }
}