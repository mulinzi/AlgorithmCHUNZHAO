/**
 * @author
 * @version 1.0
 * @date 2021/2/17 21:08
 * @description
 *      91. 解码方法
 *   要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 *
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *求映射多少种编码，0开头无法映射， 10--J  20----T
 *
 **/
//一开始就去想dp吧
//  递归：当前数字选一个或2个， 0开头无法映射，   大于26的无法映射 ?  超出时间限制
//    动态规划
//    1.当前i位置与前一个位置能组成合法数字10 - 26
//       组成的数字10 | 20 ，dp[i] = dp[i-2]
//       组成的数字非10 20  dp[i] = dp[i-1] + dp[i+2]
//    2.当前i位置与前一个位置不能组成10 -- 26之间的数
//       第i位是0，不可编码（前一个数是非1 非2 的无法编码）
//       第i位不是0，  dp[i] = dp[i-1]
 //
public class NumDecodings {
    public static void main(String[] args) {
        new NumDecodings().numDecodings("27");
    }


    public int numDecodings(String s) {
        int res = 0;
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;     //为防止越界？  这样计算第二个位置时，
        dp[1] = 1;     //这个是第一个位置的路径数   s.charAt(0) == '0' ? 0 : 1;
         for (int i = 1; i <s.length() ; i++) {
            if((s.charAt(i-1)== '1'  || s.charAt(i-1) == '2') && s.charAt(i) < '7'){
                if(s.charAt(i) == '0'){
                    dp[i + 1] = dp[i-1];
                }else{
                    dp[i + 1] = dp[i] + dp[i-1];
                }
            }else{ //与前一个数字无法解码
                if(s.charAt(i) == '0'){
                    return 0;
                }else{

                    dp[i + 1] = dp[i];
                }

            }

        }//for



        return dp[s.length()];
    }
    public int helper(int level, String s) {
//        terminate
//        完成一种解码
//        当前值为0
        if(level < s.length() && s.charAt(level) == '0') {
                return 0;
            }

        if (level >= s.length() - 1) {
            return 1;
        }
//        process  and drill down
        if (s.charAt(level) != '0') { //当前字符不是0，取当前字符，以及两个字符，继续递归
//                    10

//           分治
//                int one = helper(level + 1, s);
//                int two = 0;
//                if (level + 2 <= s.length() - 1) {
//                    two = helper(level + 2, s);
//                }
//                return one + two;
           int temp =  Integer.valueOf(String.valueOf(s.charAt(level)));
           int temp2 = Integer.valueOf(String.valueOf(s.charAt(level + 1)));
            int sum = temp *10 + temp2;
            int two =  sum < 27 ? helper(level + 2, s): 0;
            return helper(level + 1, s) + two;

            } else {
            return 0;
        }

    }


    }