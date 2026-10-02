class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for(int i =0; i<digits.length; i++){
            for(int j =0; j<digits.length; j++){
                for(int k =0; k<digits.length; k++){
                    if(j!=k && i!=j && i!=k && digits[i]!=0 && digits[k]%2==0){
                        int num = digits[i]*10 + digits[j]*100 + digits[k];
                        set.add(num);
                    }
                }
            }
        }
        return set.size();
    }
}