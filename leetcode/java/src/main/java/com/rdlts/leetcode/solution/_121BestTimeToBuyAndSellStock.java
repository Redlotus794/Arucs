package com.rdlts.leetcode.solution;

/**
 You are given an array prices where prices[i] is the price of a given stock on the ith day.

 You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



 Example 1:

 Input: prices = [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 Example 2:

 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transactions are done and the max profit = 0.


 Constraints:

 1 <= prices.length <= 105
 0 <= prices[i] <= 104
 */
public class _121BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int num = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int num2 = prices[j];
                if (num2 > num) {
                    result = Math.max(result, num2 - num);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _121BestTimeToBuyAndSellStock solution = new _121BestTimeToBuyAndSellStock();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        // Output: 5
        System.out.println(solution.maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        // Output: 0
        System.out.println(solution.maxProfit(prices2));
    }
}
