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
        int length = prices.length;
        if (length < 2)
            return 0;
            
        int[] leftPartMaxProfit = new int[length];
        int[] rightPartMaxProfit = new int[length];
        
        for (int i = 1, minPrice = prices[0]; i < length; i ++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftPartMaxProfit[i] = Math.max(leftPartMaxProfit[i - 1], prices[i] - minPrice);
        }
        
        for (int i = length - 2, maxPrice = prices[length - 1]; i >= 0; i --) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightPartMaxProfit[i] = Math.max(rightPartMaxProfit[i + 1], maxPrice - prices[i]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i ++) {
            maxProfit = Math.max(maxProfit, leftPartMaxProfit[i] + rightPartMaxProfit[i]);
        }
        return maxProfit;
    }
}