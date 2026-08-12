class Solution {
    public String rearrangeString(String s, char x, char y) {

        StringBuilder other = new StringBuilder();
        StringBuilder xs = new StringBuilder();
        StringBuilder ys = new StringBuilder();

        for(char ch : s.toCharArray()){
        if (ch == x) {
                xs.append(ch);
            } else if (ch == y) {
                ys.append(ch);
            } else {
                other.append(ch);
            }

        }
        return ys.toString() + other.toString() + xs.toString();

    }
}