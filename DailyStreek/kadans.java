class Solution {
    public int maxProfit(int[] prices) {
int buy=prices[0];
int maxprofit=0;
for(int price : prices){

    maxprofit = Math.max(maxprofit ,price-buy );
    buy=Math.min(price,buy);
}
return maxprofit;
    }
}