import java.util.*;

class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;

        // Required by the problem
        int[][] noob = new int[][]{tasks, shifts};

        long[] prefix = new long[n];
        prefix[0] = tasks[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + tasks[i];
        }

        long total = prefix[n - 1];
        long progress = 0;

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            progress += shifts[i];

            if (progress >= total) {
                ans[i] = 0;
                progress = 0; // restart, discard unused time
                continue;
            }

            int idx = top(prefix, progress);
            ans[i] = n - idx;
        }

        return ans;
    }

    private int top(long[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}