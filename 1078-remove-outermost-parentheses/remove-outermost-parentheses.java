class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // If depth > 0, this '(' is not an outermost parenthesis
                if (depth > 0) {
                    ans.append(ch);
                }
                depth++;
            } else {
                depth--;

                // If depth > 0, this ')' is not an outermost parenthesis
                if (depth > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}
