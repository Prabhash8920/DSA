import java.util.*;

class Solution {

    static class help {
        int n;
        long[] bit;

        help(int n) {
            this.n = n;
            bit = new long[n + 2];
        }

        void add(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countRatioSubarrays(int[] nums, int a, int b) {

        int[] noob = nums;

        int n = nums.length;

        long[] pref = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            if ((nums[i - 1] & 1) == 0)
                pref[i] = pref[i - 1] + b;
            else
                pref[i] = pref[i - 1] - a;
        }

        long[] all = pref.clone();
        Arrays.sort(all);

        ArrayList<Long> vals = new ArrayList<>();
        for (long x : all) {
            if (vals.isEmpty() || vals.get(vals.size() - 1) != x)
                vals.add(x);
        }

        help ft = new help(vals.size());

        long ans = 0;
        long inserted = 0;

        for (long cur : pref) {

            int idx = Collections.binarySearch(vals, cur) + 1;

            ans += inserted - ft.sum(idx - 1);

            ft.add(idx, 1);
            inserted++;
        }

        return ans;
    }
}