class Solution {
    public int countSpecialIntegers(int[] nums) {
       Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, i});
            } else {
                map.get(nums[i])[1] = i;
            }
        }

        int ans = 0;

        for (int[] pos : map.values()) {
            int first = pos[0];
            int last = pos[1];

            boolean special = true;

            for (int i = first; i <= last; i++) {
                if (nums[i] != nums[first]) {
                    special = false;
                    break;
                }
            }

            if (special) {
                ans++;
            }
        }

        return ans;
    }
}