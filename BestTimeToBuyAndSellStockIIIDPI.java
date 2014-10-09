/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIIIDPI {
        public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        
        int len = prices.length;
        int minPrice = prices[0];
        int maxProfitFromLeft[] = new int[len];
        for (int i = 1; i < len; i++) {
            maxProfitFromLeft[i] = Math.max(maxProfitFromLeft[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        int maxPrice = prices[len - 1];
        int maxProfit = 0;
        int maxProfitFromRight = 0;
        for (int i = len - 2; i >= 0; i--) {
            maxProfitFromRight = Math.max(maxProfitFromRight, maxPrice - prices[i]);
            maxProfit = Math.max(maxProfit, maxProfitFromRight + maxProfitFromLeft[i]);
            maxPrice = Math.max(prices[i], maxPrice);
        }
        
        return maxProfit;
    }
}