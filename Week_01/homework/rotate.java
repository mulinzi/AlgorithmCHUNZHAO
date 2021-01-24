package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 12:26
 * @description
 **/
public class rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            //应对k > 长度的情况
            k = k % length;
            int count = 0;

            for (int i = 0; count < length; ++i) {//?

                //从0开始，pre记录当前位置应该赋的值， temp暂存变量接收下个位置的值。curr和next为下标，
                int curr = i;
                int pre = nums[i];
                do{
                    int next = (curr + k) % length;
                    int temp = nums[next];
                    nums[next] = pre;   //前面的值后移
                    pre = temp;        //记录当前值
                    curr = next;     //指针后移，到下一个位置
                    count++;         //记录操作过的数
                }while(i != curr);
            }
        }
    }
}
