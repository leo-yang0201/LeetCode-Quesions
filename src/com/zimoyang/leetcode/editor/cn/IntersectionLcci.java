  //给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。 
//
// 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。 
//
// 
//
// 示例 1： 
//
// 输入：
//line1 = {0, 0}, {1, 0}
//line2 = {1, 1}, {0, -1}
//输出： {0.5, 0}
// 
//
// 示例 2： 
//
// 输入：
//line1 = {0, 0}, {3, 3}
//line2 = {1, 1}, {2, 2}
//输出： {1, 1}
// 
//
// 示例 3： 
//
// 输入：
//line1 = {0, 0}, {1, 1}
//line2 = {1, 0}, {2, 1}
//输出： {}，两条线段没有交点
// 
//
// 
//
// 提示： 
//
// 
// 坐标绝对值不会超过 2^7 
// 输入的坐标均是有效的二维坐标 
// 
// Related Topics 几何 数学

  
  package com.zimoyang.leetcode.editor.cn;
  public class IntersectionLcci{
      public static void main(String[] args) {
           Solution solution = new IntersectionLcci().new Solution();
           solution.intersection(new int[]{0,0},new int[]{1,1},new int[]{2,2},new int[]{3,3});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double x11 = start1[0];
        double y11 = start1[1];
        double x12 = end1[0];
        double y12 = end1[1];
        double k1,b1;
        if (x12 - x11 == 0) {
            k1 = Double.MAX_VALUE;
            b1 = 0;
        }
        else {
            k1 = (y12 - y11) / (x12 - x11);
            b1 = y11 - k1 * x11;
        }
        double x21 = start2[0];
        double y21 = start2[1];
        double x22 = end2[0];
        double y22 = end2[1];
        double k2,b2;
        if (x21 - x22 == 0) {
            k2 = Double.MAX_VALUE;
            b2 = 0;
        }
        else {
            k2 = (y22 - y21) / (x22 - x21);
            b2 = y22 - k2 * x22;
        }
        if ((k1 == k2 && b1 != b2)) {
            return new double[]{};
        }
        else {
            double x,y;
            if (k1 == k2 && b1 == b2) {
                if (k1 == Double.MAX_VALUE && k2 == Double.MAX_VALUE ) {
                    if (x21 - x11 != 0)
                    return new double[]{};
                    double y1 = Math.max(y11,y12);
                    double y2 = Math.min(y21,y22);
                    double y3 = Math.min(y11,y12);
                    double y4 = Math.max(y21,y22);
                    if (y1 >= y2 && y3 <= y4 ) {
                        y = Math.max(y2,y3);
                        x = 0;
                        return new double[]{x,y};
                    }
                    else {
                        return new double[]{};
                    }
                }
                if (k1 == Double.MAX_VALUE) {
                    x = 0;
                    y = Math.max(Math.min(y11,y12),Math.min(y21,y22));
                    return new double[]{x,y};
                }
                x = Math.max(Math.min(x11,x12),Math.min(x21,x22));
                y = Math.max(Math.min(y11,y12),Math.min(y21,y22));
                return new double[]{x,y};
            }
            x = (b2 - b1) / (k1 - k2);
            y = k1 * x + b1;
            return new double[]{x,y};
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }