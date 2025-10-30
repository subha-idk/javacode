package tree;

public class TreeNode implements Comparable<TreeNode>{
    int val;   //left|val|right
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
    //TreeNode *left;   TreeNode obj? int var = 5;

    @Override
    public int compareTo(TreeNode other) {
        return other.val - this.val;  //ascending
    }


}
