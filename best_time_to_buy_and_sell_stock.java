

/**
 *  Say you have an array for which the i th element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction
 (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class best_time_to_buy_and_sell_stock {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int min = prices[0]; //保存数组中最小的数
        int max = 0;//保存数组中交易盈利最大

        for(int i = 1;i < prices.length;i++){
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i]-min);

        }
        return max;
    }
}
