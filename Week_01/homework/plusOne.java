package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 19:48
 * @description
 **/
public class plusOne {//1.直接在数组上+1
// 2.转成整数在+1

    class Solution {
        public int[] plusOne(int[] digits) {

            int length = digits.length;
            int i = 1;
            if(digits[length - 1] < 9) { //最后一个数小于9,不用进位直接加
                digits[length - 1] ++;
                return digits;
            }else{ //需要进位
                while(i <= length && digits[length - i] == 9){ //找到进位的值
                    digits[length - i] = 0;
                    i++;
                }
                if(i > length){
                    //创建新数组
                    int [] res = new int[length +1];
                    res[0] = 1;
                    return res;
                }else{
                    digits[length - i] ++;
                    return digits;
                }

            }//else
        }//method
    }
}
