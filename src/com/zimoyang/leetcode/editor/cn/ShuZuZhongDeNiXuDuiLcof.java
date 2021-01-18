  //在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//

  
  package com.zimoyang.leetcode.editor.cn;
  public class ShuZuZhongDeNiXuDuiLcof{
      public static void main(String[] args) {

          Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
          solution.reversePairs(new int[]{7,5,6,4});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length - 1);
    }

    private int merge(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        int count = merge(nums,start,mid) + merge(nums,mid + 1,end);

        int[] temp = new int[end - start + 1];
        int i = start,j = mid + 1,k = 0;
        while (i <= mid && j <= end) {
            count += nums[i] <= nums[j] ? j - mid - 1 : 0;
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            count += j - mid - 1;
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp,0,nums,start,end - start + 1);
        return count;
    }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }