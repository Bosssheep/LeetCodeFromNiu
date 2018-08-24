package Array;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 思路：
 判断相邻是否递增，因为连续递增可以合起来看为一次买入卖出操作，所以统计所有递增量即可
 */

public class best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int profit = 0;
        for(int i = 1;i < prices.length;i++){
           if(prices[i] > prices[i-1]){
               profit = profit + prices[i]-prices[i-1];
           }

        }
        return profit;
    }
}
