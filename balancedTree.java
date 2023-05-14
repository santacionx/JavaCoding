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

// o(nh)
public class balancedTree {
    public static node input(boolean isroot, int value, boolean isleft) {
        if (isroot) {
            System.out.println("enter the root : ");
        } else {
            if (isleft) {
                System.out.println("enter the left child of : " + value);
            } else {
                System.out.println("enter the right child of " + value);
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
        System.out.print(root.data + " ");
        if (root.left != null) {
            System.out.print(" left : " + root.left.data);
        }
        if (root.right != null) {
            System.out.print(" right : " + root.right.data);
        }
        System.out.println();
        print(root.left);
        print(root.right);
    }

    public static int height(node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean balanceTree(node root) {
        if (root == null) {
            return true;
        }
        int lefts = height(root.left);
        int rights = height(root.right);
        if ((Math.abs(lefts - rights)) > 1) {
            return false;
        }
        // left tree and right tree should check
        boolean isleftbalanced = balanceTree(root.left);
        boolean isrightbalanced = balanceTree(root.right);
        return isleftbalanced && isrightbalanced;
    }

    public static void main(String[] args) {
        node root = input();
        print(root);
        // o(nh) worst n^2 / o(n)
        System.err.println("Tree is balanced ? " + balanceTree(root));
    }
}