import java.util.Arrays;

class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return gcd(nums[0], nums[n - 1]);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}