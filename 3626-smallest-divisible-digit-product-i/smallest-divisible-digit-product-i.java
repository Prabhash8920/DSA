class Solution {
    private boolean isValid(int num,int t){
        int product = 1;
        int x = num;

        if(x==0) return 0%t==0;

        while(x>0){
            int digit = x%10;
            product *= digit;
            x /= 10;
        }

        return product % t == 0;
    }
    public int smallestNumber(int n, int t) {
        while(true){
            if(isValid(n,t))
            return n ;
            n++;
        }
    }
}