class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), k, n, 1);
        return list;
    }

    private void helper(List<List<Integer>> list, List<Integer> tempList, int k, int target, int start) {

        if(target == 0 && tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        if(target < 0 || tempList.size() > k) return;

        for(int i = start; i <= 9; i++) {

            tempList.add(i);

            helper(list, tempList, k, target - i, i + 1);

            tempList.remove(tempList.size() - 1); // BACKTRACK
        }
    }
}
