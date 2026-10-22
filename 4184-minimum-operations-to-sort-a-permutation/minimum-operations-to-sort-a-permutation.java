class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Rotation of sorted array
        int k = nums[0];
        boolean ok = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (k + i) % n) {
                ok = false;
                break;
            }
        }

        if (ok) {
            return Math.min((n - k) % n, k + 2);
        }

        // Rotation of reversed sorted array
        for (int shift = 0; shift < n; shift++) {
            ok = true;

            for (int i = 0; i < n; i++) {
                int expected = (n - 1 - ((shift + i) % n));
                if (nums[i] != expected) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                return Math.min(1 + shift,
                                1 + (n - shift) % n);
            }
        }

        return -1;
    }
}