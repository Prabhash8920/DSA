class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open++;
            } else {
                // Check whether this is the second ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'
                } else {
                    // Insert a missing ')'
                    insertions++;
                }

                if (open > 0) {
                    open--;
                } else {
                    // Insert a missing '('
                    insertions++;
                }
            }
        }

        // Each remaining '(' needs two ')'
        insertions += open * 2;

        return insertions;
    }
}