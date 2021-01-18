  //给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。 
//
// 返回 至少 能删除数组中的一半整数的整数集合的最小大小。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,3,3,3,5,5,5,2,2,7]
//输出：2
//解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
//大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
//选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
// 
//
// 示例 2： 
//
// 输入：arr = [7,7,7,7,7,7]
//输出：1
//解释：我们只能选择集合 {7}，结果数组为空。
// 
//
// 示例 3： 
//
// 输入：arr = [1,9]
//输出：1
// 
//
// 示例 4： 
//
// 输入：arr = [1000,1000,3,7]
//输出：1
// 
//
// 示例 5： 
//
// 输入：arr = [1,2,3,4,5,6,7,8,9,10]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// arr.length 为偶数 
// 1 <= arr[i] <= 10^5 
// 
// Related Topics 贪心算法 数组

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.Collections;
  import java.util.Iterator;

  public class ReduceArraySizeToTheHalf{
      public static void main(String[] args) {

          Solution solution = new ReduceArraySizeToTheHalf().new Solution();
          solution.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSetSize(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1;i < arr.length;i++) {
            if (arr[i] == arr[i - 1]) {
                list.set(list.size() - 1,list.get(list.size() - 1) + 1);
            } else {
                list.add(1);
            }
        }
        Collections.sort(list);
        int num = 0;
        for (int i = list.size() - 1;i >= 0;i--) {
            num += list.get(i);
            if (num * 2 >= arr.length) {
                int ans = list.size() - i;
                return ans;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }