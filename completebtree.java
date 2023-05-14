import java.util.*;

class node {
    int data;
    node left;
    node right;

    node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class completebtree {
    public static node input(boolean isroot, int value, boolean isleft) {
        if (isroot) {
            System.out.println("Enter the root :");
        } else {
            if (isleft) {
                System.out.println("Enter the left child: " + value);
            } else {
                System.out.println("Enter the right child " + value);
            }
        }
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        node root = new node(data);
        node leftc = input(false, data, true);
        node rightc = input(false, data, false);
        root.left = leftc;
        root.right = rightc;
        return root;
    }

    public static node input() {
        return input(true, 0, true);
    }

    public static void print(node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " : ");
        if (root.left != null) {
            System.out.print(" left " + root.left.data);
        }
        if (root.right != null) {
            System.out.print(" right " + root.right.data);
        }
        System.out.println();
        print(root.left);
        print(root.right);
    }

    public static int CountNodes(node root) {
        if (root == null) {
            return 0;
        }
        return 1 + CountNodes(root.left) + CountNodes(root.right);
    }

    public static int SumNodes(node root) {
        if (root == null) {
            return 0;
        }
        return root.data + SumNodes(root.left) + SumNodes(root.right);
    }

    public static int LargestNode(node root) {
        if (root == null) {
            return -1;
        }
        return Math.max(root.data, Math.max(LargestNode(root.left), LargestNode(root.right)));
    }

    public static int Height(node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(Height(root.left), Height(root.right));
    }

    public static int CountLeafs(node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return CountLeafs(root.left) + CountLeafs(root.right);
    }

    public static void printDepth(node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        printDepth(root.left, k - 1);
        printDepth(root.right, k - 1);
    }

    public static void greaterX(node root, int x) {
        if (root == null) {
            return;
        }
        if (root.data > x) {
            System.out.print(root.data + " ");
        }
        greaterX(root.left, x);
        greaterX(root.right, x);
    }

    public static void ReplaceDepthNumber(node root, int k) {
        if (root == null) {
            return;
        }
        root.data = k;
        ReplaceDepthNumber(root.left, k + 1);
        ReplaceDepthNumber(root.right, k + 1);
    }

    public static boolean CheckXExist(node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        CheckXExist(root.left, x);
        CheckXExist(root.right, x);
        return false;
    }

    public static void Siblings(node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.err.print(root.data + " ");
            return;
        } else if (root.left != null && root.right == null) {
            System.err.print(" " + root.left.data);
        }

        Siblings(root.left);
        Siblings(root.right);
    }

    public static node removeleafnode(node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeleafnode(root.left);
        root.right = removeleafnode(root.right);
        return root;
    }

    public static void mirror(node root) {
        if (root == null) {
            return;
        }
        mirror(root.left);
        mirror(root.right);
        node temp = root.left;
        root.right = root.left;
        root.left = temp;

    }

    public static void main(String[] args) {
        node root = input();
        // print(root);
        // System.out.println("# nodes : " + CountNodes(root));
        // System.out.println(" sum nodes " + SumNodes(root));
        // System.out.println("Largest node " + LargestNode(root));
        // System.out.println("tree height " + Height(root));
        // System.out.println("#leaves " + CountLeafs(root));
        // System.out.println("Depth of k : ");
        // printDepth(root, 1);
        // System.out.println("greater than x ");
        // greaterX(root, 1);
        // ReplaceDepthNumber(root, 0);
        // print(root);
        // boolean res = CheckXExist(root, 0);
        // if (res) {
        // System.out.println("found");
        // } else {
        // System.out.println("not found");
        // }
        // Siblings(root);
        // print(root);
        // node rm = removeleafnode(root);
        // print(rm);
        print(root);
        System.out.println("root");
        mirror(root);
        print(root);
    }
}