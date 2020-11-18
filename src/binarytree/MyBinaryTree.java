package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的相关方法实现
 * @author: Deepcola
 * @time: 2020/11/18 22:36
 */
public class MyBinaryTree {
    /**
     * 定义结点
     */
    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 创建二叉树
     *           1
     *      2         3
     *    4   5    6    7
     *         8    9
     */
    public TreeNode createTree() {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode H = new TreeNode(7);
        TreeNode I = new TreeNode(8);
        TreeNode G = new TreeNode(9);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = I;
        C.left = F;
        C.right = H;
        F.right = G;
        return A;
    }

    /**
     * 遍历思路——求结点个数
     */
    public static int size = 0;
    public void getSize1(TreeNode root) {
        // 空树
        if (root == null) return;
        // 当前结点不是空结点
        size++;
        // 遍历所有结点进行判断
        getSize1(root.left);
        getSize1(root.right);
    }

    /**
     * 子问题思路——求结点个数
     */
    public int getSize2(TreeNode root) {
        // 空树
        if (root == null) return 0;
        // 递归求解同时加上每一次递归时结点本身
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    /**
     * 遍历思路——求叶子结点个数
     */
    public static int leafSize = 0;
    public void getLeafSize1(TreeNode root) {
        // 空树
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        // 遍历所有子树，遇到叶子结点长度加 1;
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    /**
     * 子问题思路——求叶子结点个数
     */
    public int getLeafSize2(TreeNode root) {
        // 空树
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 递归求所有子树下的叶子结点
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    /**
     * 子问题思路————求第 k 层结点个数
     */
    public int getKLevelSize(TreeNode root, int k) {
        // 空树
        if (root == null) return 0;
        // 相对位置第一层
        if (k == 1) return 1;
        // 递归求下一层时, 该层作为第一层
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    /**
     * 获取二叉树的高度
     */
    public int getHeight(TreeNode root) {
        // 空树
        if (root == null) return 0;
        // 分别求出左右子树的最大高度，取最大值为二叉树最大高度
        int leftHeight = getHeight(root.left) + 1;
        int rightHeight = getHeight(root.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }

    /**
     * 查找 val 所在结点，没有找到返回 null
     * 按照 根 -> 左子树 -> 右子树 的顺序查找
     * 一旦找到，立即返回，不需要在其他地方查找
     */
    public TreeNode find(TreeNode root, int val) {
        // 空树
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
        // 判断左子树和右子树有没有找到结点，找到直接返回结点
        TreeNode left = find(root.left, val);
        if (left != null) {
            return left;
        }
        TreeNode right = find(root.right, val);
        if (right != null) {
            return right;
        }
        return null;
    }

    /**
     * 判断一棵树是不是完全二叉树
     * 根据层序遍历, 从根结点开始, 所有出队结点的左右孩子全部入队(不论左右孩子是不是为 null)
     * 当出队元素是 null 时，停止出队，此时由于完全二叉树的性质队列中应该全为 null; 否则将不是完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {
        // 空树
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 当前弹出节点的左右孩子都入队(不论是不是 null)
            TreeNode temp = queue.poll();
            // 弹出节点为 null 时，停止
            if (temp == null) {
                break;
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        // 当前队列中应该全为 null; 否则就不是完全二叉树
        while (!queue.isEmpty()) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        // 创建二叉树
        TreeNode root = myBinaryTree.createTree();

        // 求结点个数
        myBinaryTree.getSize1(root);
        System.out.println("<<<<<<<结点个数>>>>>>>");
        System.out.println("  遍历思路: " + size);
        System.out.println("子问题思路: " + myBinaryTree.getSize2(root));

        // 求叶子结点个数
        myBinaryTree.getLeafSize1(root);
        System.out.println("<<<<<<<叶子结点个数>>>>>>>");
        System.out.println("  遍历思路: " + leafSize);
        System.out.println("子问题思路: " + myBinaryTree.getLeafSize2(root));

        // 求第 k 层结点个数
        int k = 3;
        System.out.println("<<<<<<<第 k 层结点个数>>>>>>>");
        System.out.println("第" + k + "层叶子结点个数: " + myBinaryTree.getKLevelSize(root,k));

        // 求二叉树的高度
        System.out.println("<<<<<<<二叉树高度>>>>>>>");
        System.out.println("二叉树高度为: " + myBinaryTree.getHeight(root));

        // 查找 val
        int val = 5;
        System.out.println("<<<<<<<查找结点>>>>>>>");
        if (myBinaryTree.find(root, val) != null) {
            System.out.println("成功找到" + val);
        }else {
            System.out.println("没有找到");
        }

        // 判断一棵树是不是完全二叉树
        System.out.println("<<<<<<<完全二叉树>>>>>>>");
        if (myBinaryTree.isCompleteTree(root)) {
            System.out.println("是完全二叉树");
        }else {
            System.out.println("不是完全二叉树");
        }
    }
}
