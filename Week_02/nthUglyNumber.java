/**
 * @author
 * @version 1.0
 * @date 2021/1/31 21:38
 * @description
 **/
public class nthUglyNumber {
    // 动态规划： 第n个一定是， 较小丑数 乘 2，3，5
// dp[i] 为第i+1个的质数
// 转移方程
//  dp[i] = min {dp[a] * 2,dp[b] *3 , dp[c] * 5}
//  更新 与dp[i] 相等的 a，b，c  值+ 1

    class Solution {
        public int nthUglyNumber(int n) {

            int[] dp = new int[n];
            int a= 0,b = 0,c = 0;
            // 1为最小丑数
            dp[0] = 1;

            for(int i = 1; i < n; i++){
                dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] *3), dp[c] * 5);
                if(dp[i] == dp[a] * 2 ) a++;
                if(dp[i] == dp[b] * 3 ) b++;
                if(dp[i] == dp[c] * 5 ) c++;
            }

            return dp[ n - 1];

        }
    }
}
