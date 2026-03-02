class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
       backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    private static void backtrack(List<List<Integer>>list,List<Integer>tempList,int [] nums, int target,int start){
        if(target==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i= start; i<nums.length; i++){
            //skip duplicates
            if(i>start&& nums[i]==nums[i-1]) continue;

            //break if number is greater than target
            if(nums[i]>target) break;

            tempList.add(nums[i]);

            backtrack(list,tempList,nums,target-nums[i],i+1);
            tempList.remove(tempList.size()-1);
            
           }
    }
}