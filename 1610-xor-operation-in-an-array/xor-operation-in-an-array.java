class Solution {
    public static int xor(int n) {
        if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else if (n % 4 == 3) return 0;
        else return n;
    }

    public int xorOperation(int n, int start) {
        int s = start >> 1;
        int e = s + n - 1;

        int res = xor(e) ^ (s > 0 ? xor(s - 1) : 0);

        if ((start & 1) == 1 && (n & 1) == 1) {
            res = (res << 1) | 1;
        } else {
            res = res << 1;
        }

        return res;
    }
}