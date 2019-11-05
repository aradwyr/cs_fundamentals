/**
 * Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * e.g.
 * IN: [7,1,5,3,6,4]        OUT: 5              // Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. (Not 7-1 = 6, as selling price needs to be larger than buying price.)
 * IN: [7,6,4,3,1]          OUT: 0              // no max profit
 *
 * Complexity: O(n) time and O(1) space
 */

public class BuySellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int[] arr2 = {7,6,4,3,1};
        System.out.println(new BuySellStock().maxProfit(arr));
        System.out.println(new BuySellStock().maxProfit(arr2));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) { minPrice = prices[i]; }
            else if (prices[i] - minPrice > maxProfit) { maxProfit = prices[i] - minPrice; }
        }
        return maxProfit;
    }
}
