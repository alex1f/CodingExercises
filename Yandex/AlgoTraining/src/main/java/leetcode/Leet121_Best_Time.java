/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.
 */

package leetcode;

public class Leet121_Best_Time {
    public int maxProfit(int[] prices){
        int maxProfit = 0;
        if (prices.length == 1){
            return maxProfit;
        }

        int currentBuyPriceIndex = 0;
        int currentSellPriceIndex = 1;

        while (currentSellPriceIndex < prices.length){
            int buyPrice = prices[currentBuyPriceIndex];
            int sellPrice = prices[currentSellPriceIndex];

            if (buyPrice >= sellPrice){
                if (currentSellPriceIndex <= prices.length-2){
                    currentBuyPriceIndex = currentSellPriceIndex;
                    currentSellPriceIndex = currentBuyPriceIndex+1;
                } else {
                    return maxProfit;
                }

            } else {
                int currentProfit = sellPrice - buyPrice;
                if (currentProfit > maxProfit){
                    maxProfit = currentProfit;
                }
                currentSellPriceIndex++;
            }
        }
        return maxProfit;
    }
}
