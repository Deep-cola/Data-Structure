package binarytree;

import java.util.*;

/**
 * @description: 二叉树的前序遍历、中序遍历、后序遍历、层序遍历
 * @author: Deepcola
 * @time: 2020/11/18 17:22
 */
public class BinaryTree {
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
     * 遍历————递归
     * 使用递归进行遍历，打印即可，不需要返回值
     */

    /**
     * 前序遍历——递归
     * 根节点 -> 左孩子 -> 右孩子
     */
    public void preOrderTraversal(TreeNode root) {
        // 空树
        if (root == null) return;
        // 递归遍历
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 中序遍历——递归
     * 左孩子 -> 根节点 -> 右孩子
     */
    public void inOrderTraversal(TreeNode root) {
        // 空树
        if (root == null) return;
        // 递归遍历
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    /**
     * 后序遍历——递归
     * 左孩子 -> 右孩子 -> 根结点
     */
    public void postOrderTraversal(TreeNode root) {
        // 空树
        if (root == null) return;
        // 递归遍历
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 层序遍历
     * 按照每一层从上往下、从左往右依次遍历
     * 结合队列先进先出的特性，让出队结点的左右孩子(如果存在)入队，这样就按照顺序把下一层的结点依次入队，然后依次出队直至队空就遍历完所有结点
     */
    public void levelOrderTraversal(TreeNode root) {
        // 空树
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            // 出队结点的左右孩子存在就入队等待依次出队
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    /**
     * 遍历————递归 + 返回值
     * 遍历后的顺序使用List<Integer>作为返回值
     */

    /**
     * 前序遍历————递归 + 有返回值
     */
    public List<Integer> preOrderTraversalList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 空树
        if (root == null) return result;
        // 递归
        // 添加根节点到 list
        result.add(root.val);
        List<Integer> left = preOrderTraversalList(root.left);
        // 添加左子树到 list
        result.addAll(left);
        List<Integer> right = preOrderTraversalList((root.right));
        // 添加右子树到 list
        result.addAll(right);
        return result;
    }

    /**
     * 中序遍历————递归 + 有返回值
     */
    public List<Integer> inOrderTraversalList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 空树
        if (root == null) return result;
        // 递归
        List<Integer> left = inOrderTraversalList(root.left);
        // 添加左子树到 list
        result.addAll(left);
        // 添加根节点到 list
        result.add(root.val);
        List<Integer> right = inOrderTraversalList((root.right));
        // 添加右子树到 list
        result.addAll(right);
        return result;
    }

    /**
     * 后序遍历————递归 + 有返回值
     */
    public List<Integer> postOrderTraversalList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 空树
        if (root == null) return result;
        // 递归
        List<Integer> left = postOrderTraversalList(root.left);
        // 添加左子树到 list
        result.addAll(left);
        List<Integer> right = postOrderTraversalList((root.right));
        // 添加右子树到 list
        result.addAll(right);
        // 添加根节点到 list
        result.add(root.val);
        return result;
    }

    /**
     * 遍历————非递归
     * 使用非递归方式遍历二叉树, 借助Stack、Queue等进行遍历
     */

    /**
     * 前序遍历——非递归
     */
    public void preOrderTraversalNor(TreeNode root) {
        // 空树
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 只有栈为空同时 cur 为空才遍历完
        // 叶结点的下一层 cur 为空; 栈空时弹出头结点/遍历完
        while (cur != null || !stack.isEmpty()) {
            // 遍历左子树一直到左子树为 mull
            while (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            // 访问父结点的右孩子
            cur = stack.pop();
            cur = cur.right;
        }
    }

    /**
     * 中序遍历——非递归
     */
    public void inOrderTraversalNor(TreeNode root) {
        // 空树
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 只有栈为空同时 cur 为空才遍历完
        // 叶结点的下一层 cur 为空; 栈空时弹出头结点/遍历完
        while (cur != null || !stack.isEmpty()) {
            // 遍历左子树一直到左子树为 mull
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 访问父结点的右孩子
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    /**
     * 后序遍历——非递归
     */
    public void postOrderTraversalNor(TreeNode root) {
        // 空树
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 记录上一次打印的结点
        TreeNode pre = null;
        // 只有栈为空同时 cur 为空才遍历完
        // 叶结点的下一层 cur 为空; 栈空时弹出头结点/遍历完
        while (cur != null || !stack.isEmpty()) {
            // 遍历左子树一直到左子树为 mull
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 获取父结点
            cur = stack.peek();
            // 查看父结点是否有右孩子或者有没有打印
            if (cur.right == null || cur.right == pre) {
                stack.pop();
                System.out.print(cur.val + " ");
                // 记录上一次打印的结点
                pre = cur;
                //cur 置空去取当前结点的父结点继续判断
                cur = null;
            }else {
                // 没有打印的话，遍历右孩子
                cur = cur.right;
            }
        }
    }

    /**
     * 层序遍历
     */
    public List<List<Integer>> levelOrderTraversalNor(TreeNode root) {
        // 空树
        if (root == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 记录当前层进入 queue 的结点个数
            int count = queue.size();
            // 添加每一层的所有结点为一个 list
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                // 左右孩子存在就入队
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(list);
        }
        return result;
    }




    public static void main(String[] args) {
        BinaryTree binaryTree =new BinaryTree();
        // 创建二叉树
        TreeNode root = binaryTree.createTree();

        // 前序遍历
        System.out.println("<<<<<<<前序遍历>>>>>>>");// 1 2 4 5 8 3 6 9 7
        binaryTree.preOrderTraversal(root);
        System.out.println("——————递归遍历");
        binaryTree.preOrderTraversalNor(root);
        System.out.println("——————非递归遍历");
        System.out.print(binaryTree.preOrderTraversalList(root));
        System.out.println("——————list 打印");

        // 中序遍历
        System.out.println();
        System.out.println("<<<<<<<中序遍历>>>>>>>");// 4 2 5 8 1 6 9 3 7
        binaryTree.inOrderTraversal(root);
        System.out.println("——————递归遍历");
        binaryTree.inOrderTraversalNor(root);
        System.out.println("——————非递归遍历");
        System.out.print(binaryTree.inOrderTraversalList(root));
        System.out.println("——————list 打印");

        // 后序遍历
        System.out.println();
        System.out.println("<<<<<<<后序遍历>>>>>>>");// 4 8 5 2 9 6 7 3 1
        binaryTree.postOrderTraversal(root);
        System.out.println("——————递归遍历");
        binaryTree.postOrderTraversalNor(root);
        System.out.println("——————非递归遍历");
        System.out.print(binaryTree.postOrderTraversalList(root));
        System.out.println("——————list 打印");

        // 层序遍历
        System.out.println();
        System.out.println("<<<<<<<层序遍历>>>>>>>");// 1 2 3 4 5 6 7 8 9
        binaryTree.levelOrderTraversal(root);
        System.out.println("——————遍历");
        System.out.print(binaryTree.levelOrderTraversalNor(root));
        System.out.println("——————分层打印");
    }
}
