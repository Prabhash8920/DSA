class Solution {
    public int countCommas(int n) {
         long ans = 0;
        long start = 1000;

        while (start <= n) {
            ans += n - start + 1;
            start *= 1000;
        }

        return (int) ans;
    }
}