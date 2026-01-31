class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n= nums.length;
        int pos[] = new int[n/2];
        int neg[] = new int[n/2];
        int p=0;
        int q =0;
        for(int num:nums){
            if(num>0){
                pos[p++] = num;
            }
            else{
                neg[q++] = num;
            }
        }

        int result[] = new int[n];
        int res =0;
        for(int i=0; i<n/2; i++){
            result[res++] = pos[i];
            result[res++] = neg[i];
        }
        return result;
    }
}