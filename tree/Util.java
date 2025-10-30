package tree;

import java.util.PriorityQueue;

public class Util {
    public static void preOrder(TreeNode root) {
        // ORDER:  root left right
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(TreeNode root) {}
    public void postOrder(TreeNode root) {}

    public static void bfs(TreeNode root) {
        if(root == null) return;

        PriorityQueue<TreeNode>  pq = new PriorityQueue<>();  //default min heap
        pq.offer(root);  //insert the root

        while(!pq.isEmpty()) {
            TreeNode node = pq.poll();
            System.out.print(node.val+" ");
            if(node.left != null) pq.offer(node.left);
            if(node.right != null) pq.offer(node.right);
        }
    }
}
