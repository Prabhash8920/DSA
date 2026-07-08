class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int res =0;
        Map<String,Integer>memo = new HashMap<>();

        for(String word: words){
            memo.put(word,1);
            for(int i=0; i<word.length(); i++){
               
                StringBuilder current = new StringBuilder(word);
                String next = current.deleteCharAt(i).toString(); //Time : Length
                //Check if the value for next is already calculated
                if(memo.containsKey(next)) {
                    //Update the value in map with the maximum possible value
                    memo.put(word, Math.max(memo.get(word), memo.get(next)+1));
                }
            }
            
            res = Math.max(res, memo.get(word));
        }
        
        return res;
         
    }
}