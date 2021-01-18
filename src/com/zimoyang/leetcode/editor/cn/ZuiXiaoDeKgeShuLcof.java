  //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.*;

  public class ZuiXiaoDeKgeShuLcof{
      public static void main(String[] args) {

          Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          public int[] getLeastNumbers(int[] arr, int k) {
              if (k == 0 || arr.length == 0) return new int[0];
              //默认是小根堆，实现大根堆需要重写一下比较器
              TreeMap<Integer,Integer> map = new TreeMap<>();
              int cnt = 0;
              for (int num : arr) {
                  // 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
                  if (cnt < k) {
                      map.put(num,map.getOrDefault(num,0) + 1);
                      cnt++;
                      continue;
                  }
                  // 否则，取出map中最大的Key（即最大的数字），判断当前数字与map中最大数字的大小关系
                  // 若当前数字比map中最大的数字还大，就直接忽略
                  // 若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1
                  Map.Entry<Integer,Integer> entry = map.lastEntry();
                  if (entry.getKey() > num) {
                      map.put(num,map.getOrDefault(num,0) + 1);
                      if (entry.getValue() == 1) map.pollLastEntry();
                      else map.put(entry.getKey(),entry.getValue() - 1);
                  }
              }

              // 返回map中的元素
              int[] res = new int[k];
              int idx = 0;
              for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                  int freq = entry.getValue();
                  while (freq-- > 0) {
                      res[idx++] = entry.getKey();
                  }
              }
              return res;
          }


      }
//leetcode submit region end(Prohibit modification and deletion)

  }