package Java;

public class DiameterBinaryTree {
    private int diameter; 
    public static void main(String[] args) {

        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(5);
        node.left.right.right = new TreeNode(6);
        DiameterBinaryTree ds = new DiameterBinaryTree();
        System.out.print(ds.getD(node));

    }

    public int getD(TreeNode node) {
         diameter = 0;
         getDiameter(node);
         return diameter;
    }

    public  int getDiameter(TreeNode node) {
        if(node == null)
        {
            return 0;
        }

        int left = getDiameter(node.left);
        int right = getDiameter(node.right);

        diameter = Math.max(diameter, left+right);
        return 1 + Math.max(left, right);


    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
    
}
