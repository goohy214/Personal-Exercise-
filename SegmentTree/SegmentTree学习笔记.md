# SegmentTree
## 笔记整理
>最近学习了segment tree，希望通过笔记整理，帮助自己消化巩固😊.

### SegmentTree能解决什么问题
> [参考视频](https://www.youtube.com/watch?v=ZBHKZF5w4YU)

输入一个数组，例如 {1, 3, 4, 0, 2, 1}; 每次 query 输入两个index, low_ibdex 和 high_index. 

要求输出是 low_index 和 high_index 之间最小的值.

例如 low_index 是 2，high_index 是 4，输出就应该是 0， 因为 4， 0， 2 中最小的数是 0.

![](https://raw.githubusercontent.com/goohy214/Personal-Exercise-/main/SegmentTree/img3.png)


#### Brute Force
Brute Force 方法，每次 query 需要遍历 high_index - low_index 个数，worest case 是数组长度.

假设有 m 个 query，数组长度为 n ，则时间复杂度是 O(mn).

#### O(1) query time
将所有中间值都先预存在 matrix 中，例如查找 index = 0 到 index = 2 间的最小值，只需要查找 matrix[0][2]. 

所以每次 query 的时间复杂度是 O（1）, 但是维护这样一个 matrix 需要时间复杂度 O(n^2) 和空间复杂度 O(n^2).

![](https://raw.githubusercontent.com/goohy214/Personal-Exercise-/main/SegmentTree/img1.png)

#### Segment Tree

Segment Tree 只需要 O(n) 的时间复杂度和 O(n) 的空间复杂度来维护. Segment Tree 的查找时间是 O(log n).

Segment Tree 本质上是二叉树，数组 {1, 3, 4, 0, 2, 1} 构成了树的叶子节点.

![](https://raw.githubusercontent.com/goohy214/Personal-Exercise-/main/SegmentTree/img2.png)

Segment Tree 的构建是一个递归的过程. 第一步将数组一分为二，分为 1，3，4 和 0，2，1；左右两边还可以再分，1，3，4可以分为 1，3 和 4；0，2，1 可以分为 0，2 和 1.

![](https://raw.githubusercontent.com/goohy214/Personal-Exercise-/main/SegmentTree/img4.png)

树的每一个节点都代表一个中间值，比如根节点处的值代表从 index 0 到 index 5 的最小值, 是 -1.

index 0 到 index 2 的最小值是 -1； index 3 到 index 5 的最小值是 0； 依此类推 ...


![](https://raw.githubusercontent.com/goohy214/Personal-Exercise-/main/SegmentTree/img5.png)


#### 范围查找

进行范围查找时，需要考虑三种情况. 第一种部分重合, 到该节点的左右子树查找；第二种完全重合，则返回当前节点的值；第三种没有重合，则返回 Integer.MAX_VALUE. 

例如现在需要进行对区间 [2,4] 的查找. 从根节点开始，[2,4] 没有完全覆盖 [0,5]，所以属于部分重合，接着到左右子树查找.

[2,4] 部分覆盖 [0,2]，继续到左右子树查找.

[2,4] 完全不和 [0,1] 重合，所以返回 Integer.MAX_VALUE. 

[2,4] 完全覆盖 [2,2], 所以返回 [2,2] 所在节点的值 4 .

依此类推 ...

![](https://raw.githubusercontent.com/goohy214/Personal-Exercise-/main/SegmentTree/img6.png)

####二叉树实现 Segment Tree

```
public class Main {
    public SegmentTreeNode root;
    
    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }
    
    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
        if (start > end) return null;
        else {
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start == end) root.val = nums[start];
            else {
                int mid = (start + end) / 2;
                root.left = buildSegmentTree(nums, start, mid);
                root.right = buildSegmentTree(nums, mid + 1, end);
                root.val = Math.min(root.left.val, root.right.val);
            }
            return root;
        }
    }
    
    public int minRange(int start, int end) {
        return minRange(root, start, end);
    }
    
    private int minRange(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && end >= root.end) return root.val;
        else if (start > root.end || end < root.start) return Integer.MAX_VALUE;
        else {
            int left = minRange(root.left, start, end);
            int right = minRange(root.right, start, end);
            return Math.min(left, right);
        }
    }

    private class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int val;
        
        private segmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            val = 0;
        }
    }
}
```
