class Solution {
    public int maxProfit(int[] prices) {
        
  int minPrice = prices[0], result = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                result = Math.max(result, prices[i] - minPrice);
            }


        }

        return result;
    }
}