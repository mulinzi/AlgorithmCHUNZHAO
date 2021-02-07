/**
 * @author
 * @version 1.0
 * @date 2021/2/7 21:06
 * @description
// *  注意边界的判断，判断target在那边的时候要有等于的边界
 **/
public class Search {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target ){
                return mid;
            }else if(nums[mid] >= nums[low]){
                if(target < nums[mid] && target >= nums[low]){
                    high = mid -1;
                }else{
                    low= mid +1;
                }
            }else if(nums[mid] < nums[high]){
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }
        } //while
        return -1;
    }
}
