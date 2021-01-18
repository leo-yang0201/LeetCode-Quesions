  //给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
           solution.permute(new int[]{1,2,3});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        backtrack(ans,new ArrayList<>(),nums);
        return ans;
//        List<List<Integer>> ans = new ArrayList<>();
//        if (nums.length == 0) return ans;
//        backtrack(ans,new ArrayList<>(),nums);
//        return ans;
    }

    private void backtrack(List<List<Integer>> ans, ArrayList<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = 0;i < nums.length;i++) {
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backtrack(ans,temp,nums);
                temp.remove((temp.size() - 1));
            }
        }

//        if (temp.size() == nums.length) {
//            ans.add(new ArrayList<>(temp));
//        } else {
//            for (int i = 0;i < nums.length;i++) {
//                if (temp.contains(nums[i])) continue;
//                temp.add(nums[i]);
//                backtrack(ans,temp,nums);
//                temp.remove(temp.size() - 1);
//            }
//        }
    }


      }
//leetcode submit region end(Prohibit modification and deletion)

  }