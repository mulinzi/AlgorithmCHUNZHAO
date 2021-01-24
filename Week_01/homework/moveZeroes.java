package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 19:48
 * @description
 **/
public class moveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {

            // int j = 0;
            // for(int i = 0; i < nums.length;i++){
            //     if(nums[i] != 0){
            //         nums[j]  = nums[i];
            //         j++;
            //     }
            // }


// j 记录的是非零元素要往前挪的位置, ij初始相同位置,
            int j = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nums[j] = nums[i];
                    if( i != j){//理解为双指针,两值的替换,j是一定会指向所有位置,0都会被替换到最后
                        nums[i] = 0;
                    }
                    j++;

                }
            }

        }
    }
}
