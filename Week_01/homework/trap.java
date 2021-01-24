package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 21:03
 * @description
 **/
public class trap {// 1.求当前列的雨水,找到当前列 左右两边的最高点,取较矮的哪一个,如果较矮的比当前列低或相等,当前列为0,否则当前列雨水为,较矮列高度-当前列高度

    class Solution {
        public int trap(int[] height) {
            int length = height.length;
            int res = 0;

            //遍历的列去掉两端,两端不会有雨水
            for(int i = 1; i < height.length; i++){
                //两端最大值
                int maxRight = 0;
                int maxLeft = 0;
                int tmp = 0; //存较矮的高度

                //分别向两端遍历
                for(int j = i -1; j >= 0; j--){
                    maxLeft = Math.max(maxLeft,height[j]);
                }
                for(int j = i + 1; j <= length - 1; j++){
                    maxRight = Math.max(maxRight,height[j]);
                }
                tmp = Math.min(maxRight,maxLeft);
                int s = tmp - height[i];
                if( s > 0){
                    res += s;
                }
            }
            return res;


        }
    }
}
