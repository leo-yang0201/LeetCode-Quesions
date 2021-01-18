  //矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。 
//
// 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。 
//
// 给出两个矩形，判断它们是否重叠并返回结果。 
//
// 
//
// 示例 1： 
//
// 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。 
// 矩形中的所有坐标都处于 -10^9 和 10^9 之间。 
// x 轴默认指向右，y 轴默认指向上。 
// 你可以仅考虑矩形是正放的情况。 
// 
// Related Topics 数学

  
  package com.zimoyang.leetcode.editor.cn;
  public class RectangleOverlap{
      public static void main(String[] args) {

          Solution solution = new RectangleOverlap().new Solution();
          int[] a1 = new int[]{2,17,6,20};
          int[] a2 = new int[]{3,8,6,20};
          solution.isRectangleOverlap(a1,a2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1.length == 0 || rec2.length == 0) return false;
        int x11 = rec1[0];
        int y11 = rec1[1];
        int x12 = rec1[2];
        int y12 = rec1[3];
        int x21 = rec2[0];
        int y21 = rec2[1];
        int x22 = rec2[2];
        int y22 = rec2[3];
        if (x12 <= x21 || x22 <= x11 || y11 >= y22 || y12 <= y21) {
            return false;
        } else return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }