class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
        long product = Long.MIN_VALUE;

        int I =-1;
        int J = -1;
        
        for(int i =0; i<n; i++){
            for(int j =i+1; j<n; j++){
                if(nums[i]+nums[j]==target && nums[i]!=nums[j]){

                long curr = (long)nums[i]*nums[j];
                if(curr>product){
                product = curr;
                    if(nums[i]>nums[j]){
                    I = i;
                    J= j;
                    }else{
                        I=j;
                        J=i;
                    }
                }
                }
                
            }
        }
        
        return new int[]{I,J};
           }    
}