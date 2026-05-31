class Solution {
 
 // RECURSION WAY
//     public int ways (int i, int[] arr,int target){
//            if(i==arr.length){
//         if(target==0) return 1;
//         else return 0;

//         }
    
//         int add = ways(i+1,arr,target-arr[i]);
//         int sub = ways(i+1,arr,target+arr[i]);
//         return add + sub;
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//       return   ways(0,nums,target);
//     }
// }



// DP WAY
static int sum;
 public int ways (int i, int[] arr,int res,int target,int[][] dp){
           if(i==arr.length){
         if(res==target) return 1;
         else return 0;

        }
        if(dp[i][res+sum]!=-1) return dp[i][res+sum];
    
         int add = ways(i+1,arr,res+arr[i],target,dp);
         int sub = ways(i+1,arr,res-arr[i] , target,dp);
         return dp[i][res+sum] = add + sub;
     }
     public int findTargetSumWays(int[] nums, int target) {
        // i -> 0 to n-1   || res = -sum to sum
        //dp[i][target+sum]= ways(i,res);
        sum =0; int n = nums.length; 
        for(int ele:nums)  sum += ele;
        int [][] dp = new int[n][2*sum+1];
        for(int i =0; i<dp.length;i++){
            java.util.Arrays.fill(dp[i], -1);
             
        }
        return  ways(0,nums,0,target,dp);
       
     }
}