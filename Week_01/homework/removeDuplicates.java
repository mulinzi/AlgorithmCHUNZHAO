package homework;

/**
 * @author
 * @version 1.0
 * @date 2021/1/23 18:19
 * @description
 **/


// 双指针
// 将不重复的元素左移,前指针p,和后指针q, 如果nums[q] = nums[p],q后移
// nums[p] != nums[q]  将nums[q] 放到p的下一个(p+1)位置,q后移

// 其实就是找到重复元素的下一个元素,将其移到正确位置,然后继续对比这个移动元素的后续元素

class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for(int q = 1;q < nums.length; q++){
            //不进if,相当于没有操作相当于,pq位置相等,q继续向后移动
            if(nums[p] != nums[q]){
                //假如是相邻不同元素,这里值不变,且先++,会使地址相同的情况下,不发生值复制
                p++;
                nums[p] = nums[q];  //
            }

        }
        return p + 1; //p一直指向的是最后一个非重复元素的位置

    }
}

