class Solution {

    static final long MOD = 1000000007;

    private long power(long x, long n) {
        if (n == 0) return 1;

        long half = power(x, n / 2) % MOD;
        long result = (half * half) % MOD;

        if (n % 2 == 1) {
            result = (result * x) % MOD;
        }

        return result;
    }

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;   // even indices
        long odd = n / 2;         // odd indices

        long evenPart = power(5, even);
        long oddPart = power(4, odd);

        return (int)((evenPart * oddPart) % MOD);
    }
}
