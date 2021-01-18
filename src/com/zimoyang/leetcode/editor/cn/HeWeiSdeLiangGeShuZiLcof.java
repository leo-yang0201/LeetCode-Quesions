//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
//


package com.zimoyang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLiangGeShuZiLcof {
    public static void main(String[] args) {

        Solution solution = new HeWeiSdeLiangGeShuZiLcof().new Solution();
        int target = 48;
        int a[] = new int[]{16, 16, 18, 24, 32};
        int[] res = solution.twoSum(a, target);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int sum = 0;
            int c = 0,d = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum < target) {
                    sum = nums[c] + nums[d];
                    d++;
                }
                else {
                    return new int[]{nums[c], nums[d - 1]};
                }
            }
            return new int[]{nums[c], nums[d - 1]};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}