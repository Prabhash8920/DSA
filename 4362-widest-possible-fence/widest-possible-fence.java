import java.util.*;

class Solution {
    public int maximumWidth(int[] planks) {

        HashMap<Long, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int x : planks) {
            long v = x;
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }

        ArrayList<Long> values = new ArrayList<>(freq.keySet());

        // width[height] = maximum number of planks having this height
        HashMap<Long, Integer> width = new HashMap<>();

        // Original planks can be used directly
        for (Map.Entry<Long, Integer> entry : freq.entrySet()) {
            width.put(entry.getKey(), entry.getValue());
        }

        // Try every pair of distinct heights
        for (int i = 0; i < values.size(); i++) {

            long x = values.get(i);
            int fx = freq.get(x);

            // x + x
            long sum = x + x;

            width.put(
                sum,
                width.getOrDefault(sum, 0) + fx / 2
            );

            // x + y
            for (int j = i + 1; j < values.size(); j++) {

                long y = values.get(j);
                int fy = freq.get(y);

                long target = x + y;

                int pairs = Math.min(fx, fy);

                width.put(
                    target,
                    width.getOrDefault(target, 0) + pairs
                );
            }
        }

        int ans = 0;

        for (int count : width.values()) {
            ans = Math.max(ans, count);
        }

        return ans;
    }
}