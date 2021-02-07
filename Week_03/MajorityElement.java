/**
 * @author
 * @version 1.0
 * @date 2021/2/4 14:42
 * @description给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1:Hash map 暴力
 * 2.排序：多数元素一定在 n/2位置上， 因为出现次数大于 n/2  时间复杂度：O(nlogn)   空间复杂度：O(logn)
 * 3.方法三：随机化  因为超过 n/2 的数组下标被众数占据了，这样我们随机挑选一个下标对应的元素并验证，有很大的概率能找到众数
 *理论上最坏情况下的时间复杂度为 O(∞)
 * 4. 分治： 整体的众数一定是两边的众数，所以分别处理数组的一半，如果两边返回的众数相同，则选择这个众数，否则比对二者哪个才是众数。
 *   长度为1时，唯一的数 就是众数
 * 5。Boyer-Moore 投票算法
 **/
public class MajorityElement {
    public int majorityElement(int[] nums) {

//    哈希
//Map<Integer,Integer> map = new HashMap();
//
//    int n = nums.length;
//        for(int num : nums){
//        int count = map.getOrDefault(num,0) + 1;
//        if(count > n/2){
//            return num;
//        }else{
//            map.put(num,count);
//        }
//    }
//
//    return  -1;
//}
//
         int res = helper(nums,0,nums.length);
        return res;
    }

    private int helper(int[] nums, int low, int high) {
//        terminate
//        只有一个元素，返回这个元素值
        if(low == high) {
            return nums[low];
        }
        int mid = (high - low) /2 + low;
        int right = helper(nums,low,mid);
        int left = helper(nums,mid+1,high);
//        两边的众数相等
        if (right == left) {
            return left;
        }else {
//            判断哪个是众数
            int rightCount = numCount(nums,right,low,high);
            int leftCount = numCount(nums,left,low,high);
            //返回胜方
            return rightCount > leftCount? rightCount: leftCount;
        }
    }

    private int numCount(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i < high ; i++) {

            if(nums[i] == num){
                count++;
            }
        }
        return  count;
    }
}
