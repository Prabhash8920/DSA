class Pair{
    int peaks;
    long cost;

    Pair(int p, long c){
        this.peaks = p;
        this.cost = c;
    }
}
class Solution {
    int [] nums;
    int n;
    int[] cost;
    Pair[] dp;

    public long minIncrease(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        cost = new int[n];

        for(int i=1; i<n-1; i++ ){
            int req = Math.max(nums[i-1] , nums[i+1]) + 1;
            cost[i] = Math.max(0,req-nums[i]);

        }
        dp = new Pair[n];
        return solve(1).cost;
       
    }
    private Pair solve(int i){
        if(i>=n-1) return new Pair(0,0);
        if(dp[i] != null) return dp[i];

        // skip 
        Pair skip = solve(i+1);
        // take 
        Pair next = solve(i+2);
        Pair take =  new Pair(1+ next.peaks, cost[i] + next.cost);

        Pair res;
        if(take.peaks>skip.peaks){
            res = take;
        } else if(skip.peaks>take.peaks){
            res = skip;
        } else{
            res = (take.cost<skip.cost) ? take : skip;
        }
        return dp[i] = res;

    }
}