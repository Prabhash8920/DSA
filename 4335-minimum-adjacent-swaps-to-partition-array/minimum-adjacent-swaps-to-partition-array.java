class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long ans = 0;
        long mid = 0, high = 0;

        for (int x : nums) {
            if (x < a) {
                ans += mid + high;
            } 
            else if (x <= b) {
                ans += high;
                mid++;
            } 
            else {
                high++;
            }
        }

        return (int)(ans % 1000000007);
    }
}