/**
 * @author
 * @version 1.0
 * @date 2021/2/7 19:29
 * @description
 * // 每次买卖第二天比第一天高的哪个股票
 **/
public class maxProfit {
    public int maxProfit(int[] prices) {
        int money = 0;
        for(int i = 1; i < prices.length;i++){
            if(prices[i] > prices[i -1]){
                money += (prices[i] - prices[i -1]);
            }
        }

        return money;
    }
}
