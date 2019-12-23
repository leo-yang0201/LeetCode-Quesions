//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
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

package com.zimoyang.leetcode.editor.en;

import java.util.Arrays;

public class MergeSortedArray{
    public static void main(String[] args) {

        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = new int[]{1,2,3,0,0,0,0};
        int[] nums2 = new int[]{2,5,6,8};
        int m = 3, n = 4;
        solution.merge(nums1,m,nums2,n);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int len1 = m - 1; int len2 = n - 1;int len = m + n - 1;
            while (len1 >= 0 && len2 >= 0){
                if (nums1[len1] < nums2[len2]){
                    nums1[len--] = nums2[len2--];
                }else {
                    nums1[len--] = nums1[len1--];
                }
            }
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
            System.out.println(Arrays.toString(nums1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}