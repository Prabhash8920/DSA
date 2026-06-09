class Solution {

    private String lcs(String a, String b) {

        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder str = new StringBuilder();

        int r = n, c = m;

        while (r > 0 && c > 0) {

            if (a.charAt(r - 1) == b.charAt(c - 1)) {
                str.append(a.charAt(r - 1));
                r--;
                c--;
            }
            else if (dp[r - 1][c] > dp[r][c - 1]) {
                r--;
            }
            else {
                c--;
            }
        }

        return str.reverse().toString(); // return LCS string
    }

    public String shortestCommonSupersequence(String s1, String s2) {

        String lcs = lcs(s1, s2);

        int i = 0, j = 0;
        StringBuilder scs = new StringBuilder();

        for (int k = 0; k < lcs.length(); k++) {

            char ch = lcs.charAt(k);

            while (i < s1.length() && s1.charAt(i) != ch) {
                scs.append(s1.charAt(i));
                i++;
            }

            while (j < s2.length() && s2.charAt(j) != ch) {
                scs.append(s2.charAt(j));
                j++;
            }

            scs.append(ch);
            i++;
            j++;
        }

        while (i < s1.length()) {
            scs.append(s1.charAt(i++));
        }

        while (j < s2.length()) {
            scs.append(s2.charAt(j++));
        }

        return scs.toString();
    }
}