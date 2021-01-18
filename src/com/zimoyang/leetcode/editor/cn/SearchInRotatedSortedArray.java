  //假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.Arrays;

  public class SearchInRotatedSortedArray{
      public static void main(String[] args) {

          Solution solution = new SearchInRotatedSortedArray().new Solution();
          int[] nums = new int[]{14,15,19,200,4,5,6,7};
          System.out.println(solution.search(nums,15));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right + 1 - left) / 2;
            if (nums[mid] < nums[right]) {
                //使用上取整的中间数，必须在上面的mid表达式的括号里+1
                if (nums[mid] <= target && target <= nums[right]) {
                    //下一轮搜索区间在[mid,right]
                    left = mid;
                } else {
                    //只要上面对了，这个区间就是上面区间的反面区间，下一轮搜索区间是[left,mid - 1]
                    right = mid - 1;
                }
            }
            else {
                //[left,mid]有序，但是为了和上一个if有同样的收缩行为，
                //我们故意只认为[left,mid - 1]有序
                //当区间只有两个元素，int mid = (left + right + 1) >>> 1；一定会取到右边
                //此时mid - 1不会越界
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    //下一轮搜索区间是[left,mid - 1]
                    right = mid - 1;
                } else {
                    //下一轮搜索区间是[mid,right]
                    left = mid;
                }
            }
        }
        //有可能区间内不存在目标元素，因此还需要做一次判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }