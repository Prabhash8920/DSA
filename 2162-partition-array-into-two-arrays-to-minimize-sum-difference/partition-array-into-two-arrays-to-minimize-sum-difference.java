class Solution {

    private int solve(List<Integer> a, List<Integer> b, int total) {
        int ans = Integer.MAX_VALUE;

        for (int x : a) {
            int target = total / 2 - x;

            int l = 0, r = b.size() - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                int sum = x + b.get(mid);
                ans = Math.min(ans, Math.abs(total - 2 * sum));

                if (b.get(mid) < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }

            if (l < b.size()) {
                int sum = x + b.get(l);
                ans = Math.min(ans, Math.abs(total - 2 * sum));
            }

            if (r >= 0) {
               
            }
        }

        return ans;
    }

    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;
        int total = 0;

        int[] nums1 = new int[n];
        int[] nums2 = new int[n];

        for (int i = 0; i < n; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + n];
            total += nums[i] + nums[i + n];
        }

        List<Integer>[] sum1 = new ArrayList[n + 1];
        List<Integer>[] sum2 = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            sum1[i] = new ArrayList<>();
            sum2[i] = new ArrayList<>();
        }

        for (int mask = 0; mask < (1 << n); mask++) {

            int tot1 = 0;
            int tot2 = 0;
            int count = 0;

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    tot1 += nums1[j];
                    tot2 += nums2[j];
                    count++;
                }
            }

            sum1[count].add(tot1);
            sum2[count].add(tot2);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(sum2[i]);
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            minDiff = Math.min(minDiff, solve(sum1[i], sum2[n - i], total));
        }

        return minDiff;
    }
}