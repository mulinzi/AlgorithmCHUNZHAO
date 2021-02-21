/**
 * @author
 * @version 1.0
 * @date 2021/2/18 11:32
 * @description
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 以当前位置为右下角的正方形 = 左上，左边，上的最小值 + 1    看图理解，一定是其中的最小值
 *dp[i][j] = min {dp[i-1][j],dp[i-1][j-1],dp[i][j-1]} + 1
 * 边界：i=0,或 j=0则dp只能为1
 * 如果当前位置=0，dp =0
 * 优化?
 *
 *https://leetcode-cn.com/problems/maximal-square/
 *
 * 计算机思维
 **/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max =0;
        if(matrix ==null || matrix.length == 0 || matrix[0].length == 0){
            return max;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        //计算机思维
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col ; j++) {
                if(matrix[i][j] == '0'){ //当前位置 为0
                    dp[i][j] = 0;   //java中默认就是0了
                }else{ //当前位置不为0
                    //判断是否在边上
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{  //不在边上
                        //dp公式
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + 1;
                    }

                }
                max = Math.max(max,dp[i][j]);
            }//for

        }//for


            return max * max;
    }
}
