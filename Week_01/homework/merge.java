package homework;

import java.util.Arrays;

/**
 * @author
 * @version 1.0
 * @date 2021/1/24 19:46
 * @description
 **/
public class merge {

    // 相比合并有序链表,数组更不好处理添加时的移动问题
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //法一 合并排序
            System.arraycopy(nums2,0 ,nums1, m , n);
            Arrays.sort(nums1);
        }
        public void merge3(int[] nums1, int m, int[] nums2, int n) {


            //题解法三  双指针+后添加
            //
            int p = m+n-1; //指向nums1最后一个位置
            int p1 = m -1; //指向nums1 最后一个元素位置
            int p2 = n - 1; //nums2最后一个元素位置

            while(p1 >= 0 && p2 >= 0){
                //将较大元素添加到p位置,并将对应大元素指针向前移动
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            }

            //有可能在2中遗漏元素,即nums2中p2前(包括)p2+1个元素比nums1中所有元素小
            System.arraycopy(nums2,0,nums1,0,p2 + 1);
        }
    }
}
