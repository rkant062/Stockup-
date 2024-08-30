package Java;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class BinaryTree {
     
    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();

    public BinaryTree() {
        root = null;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");

        dfs(node.left);

        dfs(node.right);
    }

    public void bfs(TreeNode node) {
        if (node == null) {
            return;
        }
        queue.add(node);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if(temp.left != null)  queue.add(temp.left); 
            if(temp.right != null) queue.add(temp.right);
        }      
    }

    private boolean findPathToANode(int val, TreeNode root)
    {
        if(root == null)
            return false;
        if(root.val == val) {
            System.out.print("Found");
            return true;
        }
        else {
            System.out.print(root.val+ " -> ");
            if(findPathToANode(val, root.left) || findPathToANode(val, root.right))
                return true;
        }
        return false;
    }

    private void preorderTraversal(TreeNode root)
    {
        if(root == null)
            return;
        preorderTraversal(root.left);
        System.out.print(root.val + " -> ");
        preorderTraversal(root.right);
    }

    private void inorderTraversal(TreeNode root)
    {
        if(root == null)
            return;
        System.out.print(root.val + " -> ");
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }

    private void postorderTraversal(TreeNode root)
    {
        if(root == null)
            return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);      
        System.out.print(root.val + " -> ");
    }

    private int getHeightOfTree(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) +1;
    }

    public void dfsByStack(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);

        while(!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }      
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.left.right = new TreeNode(9);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.right.left = new TreeNode(8);
        // Perform DFS
        System.out.println("DFS Traversal of the tree:");
        tree.dfsByStack(tree.root);
        System.out.println("\n\nBFS Traversal of the tree:");
        tree.bfs(tree.root);
        System.err.println();
        tree.findPathToANode(9, tree.root);
        System.err.println();
        tree.preorderTraversal(tree.root);
        System.err.println();
        tree.inorderTraversal(tree.root);
        System.err.println();
        tree.postorderTraversal(tree.root);
        System.err.println();
        System.err.println(tree.getHeightOfTree(tree.root));
    }

    //         1
    //     2          3
    // 4       5   6     7
    //   9                 8

}

// 1 
// 3 2
// 3 5 4 
// 3 5 9 
// 7 6
// 8 
