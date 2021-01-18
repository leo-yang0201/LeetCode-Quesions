这题初看觉得可以混分，然后越看越不会了，然后看了一下官方题解
方法一是前缀和+归并排序，更不会了
所以这种方法是我是想不到的，官方说明也是看不懂的，那既然有这种方法，我就尝试理解一下，下面说明一下为什么可以这么做
**官方归并排序说明**
![image.png](https://pic.leetcode-cn.com/1604693053-JPCZaj-image.png)
官方归并排序java代码，通过归并排序，每次求区间数时左右两段区间是分别有序的
```java
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long s = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }
}
```
看完后我明白如果数组是有序的，那么可以容易的求出区间数量，那么为什么对数组排序前后所求的区间数量不会改变呢，下面我来说明一下（官方并没有实际说明这一点）
**初始归并**：
此时只会有0或1个元素，不涉及左右两段的情况，是可以的
**合并归并**：
此时是有左右两段的，左右两段是分别有序的，**对前缀和数组排序并不会修改数组中元素的值，只是改变了元素是位置，如对left~right=3~5位置的前缀和排序，排序后前缀和3~5位置的数还是原来3~5位置的数，只是排列变化了**
设想一个一般的情况，现在是某一层的递归，左，右两段区间left~mid, mid+1~right的符合要求的区间数量已经通过countRangeSumRecursive计算了出来，整个left~right区间中可能的符合要求的区间情况是两端点在left~mid中；两端点在mid+1~right；一个端点在left~mid中，一个端点在mid+1~right中，所以现在只要求出第三种情况的区间数量就可以了
通过上面的说明，left~mid,mid+1~right区间中的数还是原来区间中的数，只是顺序变成了有序，而有序是容易计算符合要求的区间数量的，一个图说明为什么第三种情况排序前后符合数量的区间数量是不变的
![image.png](https://pic.leetcode-cn.com/1604740489-tzFzdh-image.png)
明白了为什么排序前后符合的区间和的数量是不变的，那么这道题也就容易看懂了