学习笔记
学习总结
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方。同学们可以将自己的思路、代码写在学习总结中。

1：暴力法，对比每个元素找到不是有序的地方
~~~~
public int search(int[] nums){
    int res = 0;
    for(int i = 1; i < nums.length;i++){
        if(nums[i]<nums[i-1]){
            return i;
        }
    
    }
}
~~~~
2.二分：每次找中间位置，如果num[mid] < num[low] ,则前半部分是无序的， num[high] < num[mid]
 假如在一次折半后，发现两边都是有序的，返回当前mid？
~~~~

 ********************
 public int search(int[]nums]){
      int low = 0, high = nums.length;
      int mid = -1;
      while(low <= high){
        mid = (low + high) /2;
        if(num[mid] < num[low]){
           high = mid -1;
        }else if(num[mid] >= num[high]){
             low = mid + 1;
        }else{  //两边有序
        return  mid;
        }
        
        return mid;
      }
      
  
  }

