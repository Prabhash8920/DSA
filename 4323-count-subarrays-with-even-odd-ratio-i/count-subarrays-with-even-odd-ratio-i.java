class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int[] pro = nums;

        int n = pro.length;
        int ans=0;

        for(int i =0; i<n; i++){
            int even =0; 
            int odd =0;

            for(int j =i; j<n; j++){
                if((pro[j] & 1)==0){
                    even++;
                } else{
                    odd++;
                }

                if(odd>0 && 1L*(even*b)<=(odd*a)){
                    ans++;
                }
            }
            
        }
        return ans;
        
    }
}