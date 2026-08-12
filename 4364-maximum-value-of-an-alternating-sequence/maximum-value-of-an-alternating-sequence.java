class Solution {
    public long maximumValue(int n, int s, int m) {
          if (n == 1) {
            return s;
        }

        long up = n / 2;

        return (long) s + up * m - (up - 1);
    }
}