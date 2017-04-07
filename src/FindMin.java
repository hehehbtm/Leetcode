/**
 * Created by admin on 2017/4/7.
 */
// 旋转数组找最小值
public class FindMin {
//    暴力解法
    public int findMin1(int[] nums) {
        if (nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i]>nums[i+1])
                return nums[i];
        }
        return nums[0];
    }
//    二分查找  有序数组 无重复元素 旋转
//    （1） 先判断数组是否旋转
//    （2） 和left 元素进行对比
    public int findMin2(int[] nums) {
        if (nums.length==0) return 0;
        int left = 0, right = nums.length - 1;
        if (nums[left]>nums[right]){
            while (left!=right-1){
                int mid = (left+right)/2;
                if (nums[left]<nums[mid]) left = mid;
                else right = mid;
            }
            return Math.min(nums[left],nums[right]);
        }
        return nums[0];
    }
//    旋转有序数组  有重复元素
//    关键是出现mid == right时  右移right
    public int findMin(int[] nums){
        int left = 0,right = nums.length -1;
        while (left<right){
            int mid = (right+left)/2;
            if (nums[mid]<nums[left])
                right = mid;
            else if (nums[mid]>nums[right])
                left = mid + 1;
            else
                right--;
        }
        return nums[left];
    }
}
