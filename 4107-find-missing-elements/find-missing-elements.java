class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer>ans = new ArrayList<>();

        for(int i =0; i<nums.length-1;i++){
            for(int x = nums[i]+1; x<nums[i+1]; x++){
                ans.add(x);
            }
        }
        return ans;
    }
}