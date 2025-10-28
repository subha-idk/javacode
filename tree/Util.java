package tree;

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
}
