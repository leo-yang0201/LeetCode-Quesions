  //给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.*;

  public class IntersectionOfTwoArraysIi{
      public static void main(String[] args) {

          Solution solution = new IntersectionOfTwoArraysIi().new Solution();
          int[] nums1 = {1,2,2,1,4,2,4,1,3,27};
          int[] nums2 = {2,2,7,4};
          solution.intersect(nums1,nums2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int p1 = 0,p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) p1++;
            else if (nums1[p1] > nums2[p2]) p2++;
            else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0;i < res.length;i++) res[i] = list.get(i);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }