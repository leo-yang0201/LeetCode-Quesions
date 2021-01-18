  //给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.HashSet;

  public class SurroundedRegions{
      public static void main(String[] args) {
           Solution solution = new SurroundedRegions().new Solution();
           char[][] board = new char[][]{{'X','O','X'},{'X','O','X'},{'X','O','X'}};
           solution.solve(board);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        //考虑除去边界以外的所有O
        boolean[][] visited = new boolean[row][col];
        for (int i = 0;i < col;i++) {
            //最上面一行的所有O做dfs
            if (board[0][i] == 'O') {
                dfs(0,i,board,visited);
            }
            //最下面一行所有O做dfs
            if (board[board.length - 1][i] == 'O') {
                dfs(board.length - 1,i,board,visited);
            }
        }
        for (int i = 1;i < row - 1;i++) {
           if (board[i][0] == 'O') {
               //最左边一行所有O做dfs
               dfs(i,0,board,visited);
           }
           if (board[i][board[0].length - 1] == 'O') {
               //最右边一行所有O做dfs
               dfs(i,board[0].length - 1,board,visited);
           }
        }
        //所有没标记过的O改为X
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                //省略了对X的判断，把X变成X不影响结果
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int row,int col,char[][] board,boolean[][] visited) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        if (board[row][col] == 'O') {
            visited[row][col] = true;
            dfs(row + 1,col,board,visited);
            dfs(row,col + 1,board,visited);
            dfs(row,col - 1,board,visited);
            dfs(row - 1,col,board,visited);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }