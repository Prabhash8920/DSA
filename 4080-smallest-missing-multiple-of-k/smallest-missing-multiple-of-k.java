class Solution {
    public int missingMultiple(int[] nums, int k) {
         HashSet<Integer> set = new HashSet<>();

        // store all elements rom nums
        for(int num:nums){
            set.add(num);
        }
        //check all multiple
        int multiple = k;

        while(set.contains(multiple)){
            multiple += k;
        }
        return multiple;
    }
}