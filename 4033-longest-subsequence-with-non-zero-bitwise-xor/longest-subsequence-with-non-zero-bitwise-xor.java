class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
       int xor =0;
       boolean hasZero =false;

       for(int num:nums){
        xor ^= num;

        if(num!=0){
            hasZero =true;
        }
       }
       if(xor!=0){
        return n;
       }
       if(hasZero){
        return n-1;
       }
       return 0;

    }
}    