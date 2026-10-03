class Solution {

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // pal[i][j] = true if s[i...j] is palindrome
        boolean[][] pal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        int count = 0;
        int start = 0;

        // Find palindrome with earliest ending position
        for (int end = k - 1; end < n; end++) {

            for (int i = start; i <= end - k + 1; i++) {

                if (pal[i][end]) {

                    count++;

                    // Next substring must start after this one
                    start = end + 1;

                    break;
                }
            }
        }

        return count;
    }
}