class Solution {
    private int gcd(int a , int b){
        while(b!=0){
            int temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans =1;

        int i =0; 
        while(i<n){
            int rem = nums[i]%k;

            int j =i;
            while(j<n && nums[j]%k==rem){
                j++;
            }
            int len = j-i;

            int g = gcd(rem,k);

            int s = k/g;

            int good = 1 +((len-1)/s)*s;

            ans = Math.max(ans,good);

            i=j;
                
        }
        return ans;
    }
}