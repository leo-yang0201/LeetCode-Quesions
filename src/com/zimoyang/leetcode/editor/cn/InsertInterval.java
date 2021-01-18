//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
// Related Topics 排序 数组

package com.zimoyang.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {

        Solution solution = new InsertInterval().new Solution();
        int[][] intervals = new int[][]{{1,3},{6,9}};
        int[] newInterval = new int[]{2,5};
        solution.insert(intervals,newInterval);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (newInterval == null || intervals == null) {
                return intervals;
            }

            List<int[]> res = new ArrayList<int[]>();
            int i = 0; //插入位置

            for (int[] interval : intervals) { //遍历intervals
                if (interval[1] < newInterval[0]) { //如果当前区间的end小于新区间的start，说明无重叠，直接添加
                    res.add(new int[]{interval[0], interval[1]});
                    i++;//插入位置 + 1
                } else if (interval[0] > newInterval[1]) { //如果当前区间的start小于新区间的end，说明无重叠，直接添加
                    res.add(new int[]{interval[0], interval[1]});
                } else { //否则一定有重叠，取两个区间的最小start，和最大end，作为新区间
                    newInterval[0] = Math.min(interval[0], newInterval[0]);
                    newInterval[1] = Math.max(interval[1], newInterval[1]);
                }
            }
            res.add(i, new int[]{newInterval[0], newInterval[1]});
            return res.toArray(new int[res.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    }
