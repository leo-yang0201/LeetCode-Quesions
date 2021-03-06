  //给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.LinkedList;
  import java.util.Queue;

  public class NumberOfIslands{



      public static void main(String[] args) {

          Solution solution = new NumberOfIslands().new Solution();
          char[][] grid1 = {
                  {'1', '1', '1', '1', '0'},
                  {'1', '1', '0', '1', '0'},
                  {'0', '0', '1', '0', '0'},
                  {'0', '0', '0', '1', '1'}};

          solution.numIslands(grid1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid,i,j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid,int i,int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid,i + 1,j);
        DFSMarking(grid,i - 1,j);
        DFSMarking(grid,i,j+ 1);
        DFSMarking(grid,i,j - 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }