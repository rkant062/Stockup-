package Java;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class TreeLCA {

    public static boolean findPath(TreeNode root, List<Integer> path, int k) {
        if (root == null) {
            return false;
        }

        path.add(root.value);

        if (root.value == k) {
            return true;
        }

        if ((root.left != null && findPath(root.left, path, k)) ||
            (root.right != null && findPath(root.right, path, k))) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.value == n1 || root.value == n2) {
            return root;
        }

        TreeNode leftLCA = findLCA(root.left, n1, n2);
        TreeNode rightLCA = findLCA(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static List<Integer> getPathBetweenNodes(TreeNode root, int n1, int n2) {
        TreeNode lca = findLCA(root, n1, n2);

        if (lca == null) {
            System.out.println("LCA does not exist.");
            return new ArrayList<>();
        }

        List<Integer> pathToN1 = new ArrayList<>();
        List<Integer> pathToN2 = new ArrayList<>();

        findPath(lca, pathToN1, n1);
        findPath(lca, pathToN2, n2);

        List<Integer> resultPath = new ArrayList<>(pathToN1);
        for (int i = 1; i < pathToN2.size(); i++) {
            resultPath.add(pathToN2.get(i));
        }

        return resultPath;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> path = getPathBetweenNodes(root, 4, 7);
        TreeNode lca = findLCA(root, 6,7);

        System.out.println("Path between 4 and 7: " + path);
        System.out.println(lca.value);
    }
}
