  //给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

  
  package com.zimoyang.leetcode.editor.cn;


  import java.util.ArrayList;
  import java.util.Collections;

  public class MergeSortedArray{
      public static void main(String[] args) {
           Solution solution = new MergeSortedArray().new Solution();
           solution.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //双指针法，i指向nums1的m - 1，j指向nums2的末尾
        int i = m - 1;
        int j = n - 1;
        int len = nums1.length - 1;
        while ((i >= 0) && (j >= 0)) {
            //比较nums1和nums2大小，进行赋值操作
            nums1[len--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2,0,nums1,0,j + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }