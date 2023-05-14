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

class breturn {
    boolean isbalanced;
    int height;
}

public class btreeimproved {
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

    // o(n)
    public static breturn balanceTree(node root) {
        if (root == null) {
            breturn ans = new breturn();
            ans.height = 0;
            ans.isbalanced = true;
            return ans;
        }
        breturn left = balanceTree(root.left);
        breturn right = balanceTree(root.right);
        int height = 1 + Math.max(left.height, right.height);
        boolean isbal = true;
        if (Math.abs(left.height - right.height) > 1) {
            isbal = false;
        }
        if (!left.isbalanced || !right.isbalanced) {
            isbal = false;
        }
        breturn ans = new breturn();
        ans.height = height;
        ans.isbalanced = isbal;
        return ans;
    }

    public static boolean balancedTrees(node root) {
        if (root == null) {
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if ((Math.abs(lh - rh)) > 1) {
            return false;
        }
        boolean isleft = balancedTrees(root.left);
        boolean isright = balancedTrees(root.right);
        return isleft && isright;
    }

    public static void main(String[] args) {
        node root = input();
        print(root);
        balancedTrees(root)
        System.out.println(balancedTrees(root));
        // o(nh) worst n^2 / o(n)
        breturn ans = balanceTree(root);

        System.out.println("Tree is balanced ? ");
        System.out.println(ans.isbalanced);
    }
}
