class Solution {
     static int[] reverse(int[] arr){
        int n = arr.length;
        int[] rev = new int[n];
        for(int i = 0; i < n; i++){
            rev[i] = arr[n - 1 - i];
        }
        return rev;
    }
    public int[] sortedSquares(int[] nums) {
        int  n= nums.length;
        int left = 0;
        int right = n-1;
        int [] ans = new int[n];
        int k =0;
        while(left<=right){
                if(Math.abs(nums[left])>Math.abs(nums[right])){
                    ans[k++] = nums[left]*nums[left];
                    left++;
                }
                else{
                    ans[k++] = nums[right]*nums[right];
                    right--;
                }

            }
            return reverse(ans);
      
    }
}