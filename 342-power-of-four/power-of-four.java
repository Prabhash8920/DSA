class Solution {
   
    public boolean isPowerOfFour(int n) {
        return(isPowerOfTwo(n) && isSquare(n));
    }
     boolean isPowerOfTwo(int n){
        return n>0 && (n&(n-1))==0;
    }
    boolean isSquare(int n){
        int root = (int)Math.sqrt(n);
        return (root*root==n);
    }
}