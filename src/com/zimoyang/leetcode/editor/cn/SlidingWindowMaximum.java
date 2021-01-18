  //给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.*;

  public class SlidingWindowMaximum{
      public static void main(String[] args) {

          Solution solution = new SlidingWindowMaximum().new Solution();
          int[] nums = {1,3,-1,-3,5,3,6,7};
          solution.maxSlidingWindow(nums,3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> max = new ArrayDeque<>();
       int n = nums.length;
       if (n == 0) return nums;
       int res[] = new int[n - k + 1];
       int index = 0;
       for (int i = 0;i < n;i++) {
           if (i >= k) {
               if (max.peekFirst() == nums[i - k]) {
                   max.removeFirst();
               }
           }
           while (!max.isEmpty() && nums[i] > max.peekLast()) {
               max.removeLast();
           }
           max.addLast(nums[i]);
           if (i >= k - 1) {
               res[index++] = max.peekFirst();
           }
       }
       return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }