class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        char[] a = s1.toCharArray();

        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Already equal
            if (a[i] == s2.charAt(i)) {
                continue;
            }

            // 0 -> 1 : directly possible
            if (a[i] == '0') {
                a[i] = '1';
                ans++;
            }

            // 1 -> 0
            else {
                // Last position
                if (i == n - 1) {
                    // Need help from previous position
                    if (i == 0) {
                        return -1;
                    }

                    // Make previous 0 -> 1
                    a[i - 1] = '1';

                    // 11 -> 00
                    a[i - 1] = '0';
                    a[i] = '0';

                    ans += 2;
                }

                // Next position is 1
                else if (a[i + 1] == '1') {
                    // 11 -> 00
                    a[i] = '0';
                    a[i + 1] = '0';

                    ans++;
                }

                // Next position is 0
                else {
                    // Make next 0 -> 1
                    a[i + 1] = '1';
                    ans++;

                    // Now 11 -> 00
                    a[i] = '0';
                    a[i + 1] = '0';
                    ans++;
                }
            }
        }

        return ans;
    }
}