class Solution {
    private int profit(int i , int buysell,int[]prices,HashMap<String,Integer>hm){
        if(i>=prices.length)
            return 0;
        
       String key = i + "codebix" + buysell;
        if(hm.containsKey(key))
            return hm.get(key);
            
        int x =0;
        if(buysell==0){
            int buy = profit(i+1,1,prices,hm)-prices[i];
            int notbuy = profit(i+1,0,prices,hm);
            x = Math.max(buy,notbuy);
        }
        else{
            int sell = profit(i+2,0,prices,hm)+ prices[i];
            int notsell = profit(i+1,1,prices,hm);
            x = Math.max(sell,notsell);
        }
        hm.put(key,x);
        return x ;
    }
    public int maxProfit(int[] prices) {
        HashMap<String,Integer>hm = new HashMap();
        return profit(0,0,prices,hm);
        
        
    }
}