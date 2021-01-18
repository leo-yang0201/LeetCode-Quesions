//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
// Related Topics 数组 动态规划


package com.zimoyang.leetcode.editor.cn;

import java.util.HashMap;

public class UniquePaths {
    public static void main(String[] args) {

        Solution solution = new UniquePaths().new Solution();
        int m = 3, n = 4;
        solution.uniquePaths(m, n);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            HashMap<String,Integer> visited = new HashMap<>();
            return getAns(0,0,m - 1,n - 1,0,visited);
        }

        private int getAns(int x, int y, int m, int n, int num, HashMap<String, Integer> visited) {
            if (x == m && y == n) return 1;
            int n1 = 0,n2 = 0;
            String key = x + 1 + "@" + y;
            //判断当前点是否已经求过了
            if (!visited.containsKey(key)) {
                //向右探索所有的解
                if (x + 1 <= m) {
                    n1 = getAns(x + 1,y,m,n,num,visited);
                }
            } else {
                n1 = visited.get(key);
            }
            key = x + "@" + (y + 1);
            if (!visited.containsKey(key)) {
                //向左探索所有的解
                if (y + 1 <= n) {
                    n2 = getAns(x,y + 1,m,n,num,visited);
                }
            } else {
                n2 = visited.get(key);
            }
            //将当前点加入visited中
            key = x + "@" + y;
            visited.put(key,n1 + n2);
            return n1 + n2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}