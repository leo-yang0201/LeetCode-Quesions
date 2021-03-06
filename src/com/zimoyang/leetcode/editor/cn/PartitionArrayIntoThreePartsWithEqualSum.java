  //给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。 
//
// 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... +
// A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。 
//
// 
//
// 示例 1： 
//
// 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
// 
//
// 示例 2： 
//
// 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 50000 
// -10^4 <= A[i] <= 10^4 
// 
// Related Topics 数组

  
  package com.zimoyang.leetcode.editor.cn;
  public class PartitionArrayIntoThreePartsWithEqualSum{
      public static void main(String[] args) {
           Solution solution = new PartitionArrayIntoThreePartsWithEqualSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A){
            sum += i;
        }
        if (sum % 3 != 0) return false;  // 总和不是3的倍数，直接返回false
        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];
        //使用left + 1 < right以防止数组分成两个部分
        //例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while (left + 1 < right) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                return true;// 左右两边都等于 sum/3 ，中间也一定等于
            }
            if (leftSum != sum / 3) {
                leftSum += A[++left];// left = 0赋予了初值，应该先left++，在leftSum += A[left];
            }
            if (rightSum != sum / 3) {
                rightSum += A[--right];// right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
            }
        }
    return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }