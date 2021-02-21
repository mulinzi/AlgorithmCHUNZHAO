/**
 * @author
 * @version 1.0
 * @date 2021/2/18 12:26
 * @description
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * 二维图， i行，j列  dp[i,j] 代表i j的字符串是否为回文
 *  i==j的情况为true    j-i == 1,两个字符的情况，若相等为true
 * 子问题：首尾相等的情况下，在去掉首尾的情况下，子串是否为回文   dp[i+1] [j-1]
 * j>= i的情况 ，图中上半区
 * 从左上角开始遍历，固定j，遍历i， 保证 i+1都计算过
 * i行，j列
 *
 * 降维
 **/
public class CountSubstrings {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int count = 0;
        for (int j = 0; j < length ; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j){
                    dp[i][j] = true;
                    count++;
                }else if(j -i == 1){ //两个字符
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true; // boolean 默认为false
                        count++;
                    }
                }else if(s.charAt(i) == s.charAt(j) && j -1 > 0 &&  dp[i+1][j-1] == true){
                    dp[i][j] = true;
                    count++;
                }

            }//for

        }//for



        return count;
    }
}
