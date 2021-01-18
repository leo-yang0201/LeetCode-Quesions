  //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 说明： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 
// Related Topics 堆 哈希表

  
  package com.zimoyang.leetcode.editor.cn;

  import java.util.*;

  public class TopKFrequentElements{
      public static void main(String[] args) {

          Solution solution = new TopKFrequentElements().new Solution();
//          solution.topKFrequent(new int[]{1,1,1,2,2,3,3,4,5,6,6},4);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //统计每个元素出现的次数，元素为键，元素出现次数为值
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums ) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num) + 1);
            } else {
                map.put(num,1);
            }
        }
        //遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }
        //取出最小堆中的元素
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.remove());
        }
        int[] ans = new int[list.size()];
        for (int i = 0;i < list.size();i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }