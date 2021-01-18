  //给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

  
  package com.zimoyang.leetcode.editor.cn;
  public class MedianOfTwoSortedArrays{
      public static void main(String[] args) {

          Solution solution = new MedianOfTwoSortedArrays().new Solution();
          int[] nums1 = new int[]{1,3,4};
          int[] nums2 = new int[]{2,7};
          solution.findMedianSortedArrays(nums1,nums2);

      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = (m + n + 1) / 2;
        //在nums1的区间[0,m]里查找恰当的分割线
        //使得nums1[i - 1] <= nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                //下一轮搜索的区间[left,i - 1]
                right = i - 1;
            } else {
                //下一轮搜索的区间[i,right]
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 == 1) {
            return Math.max(nums1LeftMax,nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax,nums2LeftMax) + Math.min(nums1RightMin,nums2RightMin))) / 2;
        }
    }
    }

//leetcode submit region end(Prohibit modification and deletion)

  }