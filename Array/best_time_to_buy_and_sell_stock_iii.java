package Array;

import java.util.Map;

/**
 Say you have an array for which the i th element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete at most two transactions.
 思路：
 用sell1表示初始时身上的净利润为0，buy1之后用于存放最便宜股价的价格。
 一个循环表示时间一天天推移，第一天时buy1记录下第一天买入股票身上净利润，
 之后每进入新的一天（今天），就用buy1表示前些天最便宜的股价，sell1保存了前些天买入最便宜股票之后再在股价最高时卖出股票的最大利润。
 新的一天到来，再用buy1继续记录最低股价，再计算出在今天抛售那个最低价股票后的利润，如果这个利润比之前保存的sell1高，那就更新sell1，否则，sell1不变。
·
 */

public class best_time_to_buy_and_sell_stock_iii {
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;

        for(int i = 0;i < prices.length;i++){
          buy1 = Math.max(buy1,-prices[i]);
          sell1 = Math.max(sell1,buy1+prices[i]);
          buy2 = Math.max(buy2,sell1-prices[i]);
          sell2 = Math.max(sell2,buy2+prices[i]);

        }
        return sell2;
    }
    public  static  void  main(String[] args){
        int[] prices = {1,2};
        int value = maxProfit(prices);
    }
}
