package tree;

public class Lect1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;


        //System.out.println(root);
        System.out.println("Preorder traversal of the tree is : ");
        Util.preOrder(root);

        //1. inOrder, postOrder
        //2. implement linkedlist 2,4,9,14 singly,doubly
        //3. traverse or print the data.

        System.out.println("\n Breadth first traversal (BFS) of the tree is : ");
        Util.bfs(root);
    }
}
