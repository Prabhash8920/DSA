class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int i = 0;
        int ones = 0;
        String result = "";

        for (int j = 0; j < n; j++) {

            // Add current character
            if (s.charAt(j) == '1') {
                ones++;
            }

            // If we have more than k ones, move left
            while (ones > k) {
                if (s.charAt(i) == '1') {
                    ones--;
                }
                i++;
            }

            // If we have exactly k ones,
            // remove leading zeros to make it shortest
            if (ones == k) {
                while (i < j && s.charAt(i) == '0') {
                    i++;
                }

                String temp = s.substring(i, j + 1);

                if (result.isEmpty()
                        || temp.length() < result.length()
                        || (temp.length() == result.length()
                            && temp.compareTo(result) < 0)) {
                    result = temp;
                }
            }
        }

        return result;
    }
}
