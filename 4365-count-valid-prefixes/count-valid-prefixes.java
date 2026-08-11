class Solution {
    public int countValidPrefixes(String s) {
        int ans =0;
        int balance =0;

        for(char c : s.toCharArray()){
            if(c=='0'){
                balance++;
            }else{
                balance--;
            }
          if (Math.abs(balance) <= 1){
                ans++;
            }
        }
        return ans;
    }
}