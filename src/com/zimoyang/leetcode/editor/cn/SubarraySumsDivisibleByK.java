  //给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。 
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表

  
  package com.zimoyang.leetcode.editor.cn;
  public class SubarraySumsDivisibleByK{
      public static void main(String[] args) {
           Solution solution = new SubarraySumsDivisibleByK().new Solution();
           int[] A = {4,5,0,-2,-3,1};
           int K = 5;
           int res = solution.subarraysDivByK(A,K);
          System.out.println(res);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int ans = 0;
        int index = 0;

        while (index < A.length) {
            int sum = A[index];
            for (int i = index + 1;i <= A.length;i++) {
                if (sum % K == 0) {
                    ans++;
                }
                if (i == A.length) break;
                sum += A[i];
            }
            index++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }