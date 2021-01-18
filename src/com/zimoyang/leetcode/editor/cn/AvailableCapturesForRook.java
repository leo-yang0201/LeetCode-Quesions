  //在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B
//” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。 
//
// 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜
//色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。 
//
// 返回车能够在一次移动中捕获到的卒的数量。 
// 
//
// 示例 1： 
//
// 
//
// 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",
//".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",
//".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".",
//"."],[".",".",".",".",".",".",".","."]]
//输出：3
//解释：
//在本例中，车能够捕获所有的卒。
// 
//
// 示例 2： 
//
// 
//
// 输入：[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".",
//"p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B",
//"p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".",
//"."],[".",".",".",".",".",".",".","."]]
//输出：0
//解释：
//象阻止了车捕获任何卒。
// 
//
// 示例 3： 
//
// 
//
// 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",
//".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",
//".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".",
//"."],[".",".",".",".",".",".",".","."]]
//输出：3
//解释： 
//车可以捕获位置 b5，d6 和 f5 的卒。
// 
//
// 
//
// 提示： 
//
// 
// board.length == board[i].length == 8 
// board[i][j] 可以是 'R'，'.'，'B' 或 'p' 
// 只有一个格子上存在 board[i][j] == 'R' 
// 
// Related Topics 数组

  
  package com.zimoyang.leetcode.editor.cn;
  public class AvailableCapturesForRook{
      public static void main(String[] args) {

          Solution solution = new AvailableCapturesForRook().new Solution();
          char[][] board = {
                  {'.', '.', '.', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', 'p', '.', '.', '.', '.'},
                  {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                  {'.', '.', '.', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', 'p', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', '.', '.', '.', '.'},
                  {'.', '.', '.', '.', '.', '.', '.', '.'}
          };
          System.out.println(solution.numRookCaptures(board));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRookCaptures(char[][] board) {
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        for (int i = 0;i < 8;i++) {
            for (int j = 0;j < 8;j++) {
                if (board[i][j] == 'R') {
                    int res = 0;
                    for (int[] direction : directions) {
                        if (burnout(board,i,j,direction)) {
                            res++;
                        }
                    }
                    return res;
                }
            }
        }
        return -1;
    }


    private boolean burnout(char[][] board,int x,int y,int[] direction) {
        int i = x;
        int j = y;
        while (inArea(i,j)) {
            //  遇到象，直接返回换方向
            if (board[i][j] == 'B') {
                break;
            }
            // 遇到卒，返回true，上一层res就会加一，代表吃了一个卒
            if (board[i][j] == 'p') {
                return true;
            }

            i += direction[0];
            j += direction[1];
        }
        return false;

    }

    private boolean inArea(int i,int j) {
        return i >=0 && i < 8 && j>=0 && j < 8;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }