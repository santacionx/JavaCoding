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

public class postorder {
    public static node input(boolean isroot, int value, boolean isleft) {
        if (isroot) {
            System.out.println("Enter the root :");
        } else {
            if (isleft) {
                System.out.println("Enter the left  of : " + value);
            } else {
                System.out.println("Enter the right  of : " + value);
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

    public static node input() {
        return input(true, 0, true);
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

    public static void main(String[] args) {
        node root = input();
        print(root);
        System.out.println("depth of k level wise");
        printDepth(root, 2);

    }
}
