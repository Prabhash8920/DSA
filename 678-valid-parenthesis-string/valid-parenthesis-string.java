class Solution {
    public boolean checkValidString(String s) {
       Stack<Integer> extraOpen = new Stack<>();
       Stack<Integer> astrick = new Stack<>();
       for(int i =0; i<s.length(); i++){
        char ch = s.charAt(i);
        if(ch=='('){
            extraOpen.push(i);
        } else if(ch=='*'){
            astrick.push(i);
        }else{
            //closing
            if(!extraOpen.isEmpty()){
                extraOpen.pop();
            }else if(!astrick.isEmpty()){
                astrick.pop(); // * is treated as (
            }else{
                return false;
            }
        }
       }
       while(!extraOpen.isEmpty()){
        if(astrick.isEmpty()){
            return false;
        }
        int openIndex = extraOpen.pop();
        int closedIndex = astrick.pop();
        if(openIndex>closedIndex){
            return false;
        }
       }
       return extraOpen.isEmpty();

    }
}