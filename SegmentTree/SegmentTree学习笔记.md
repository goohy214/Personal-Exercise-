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

![](https://raw.githubusercontent.com/goohy214/Personal-Exercise-/main/SegmentTree/img5.png)
