class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 1;

        for(int i =0; i<n; i++){
            int rem1 = ((nums[i]%k)+k)%k;
            for(int j =i; j<n; j++){
                int rem2 = ((nums[j]%k)+k)%k;

                if(rem2!=rem1){
                    break;
                }
                int len = j-i+1;
                if((long)(len-1)*rem1%k==0){
                    ans = Math.max(ans,len);
                }
            }
        }
        return ans;
    }
}