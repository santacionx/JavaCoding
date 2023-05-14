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

public class btree {
    public static node input(boolean isroot, int parentData, boolean isleft) {
        if (isroot) {
            System.out.println("enter the root : ");
        } else {
            if (isleft) {
                System.out.println("enter the left child of  :" + parentData + " ");
            } else {
                System.out.println("enter the right child : " + parentData + " ");
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
        if (root.left != null)
            System.out.print(" left: " + root.left.data);
        if (root.right != null)
            System.out.print(" right: " + root.right.data);
        System.out.println();
        print(root.left);
        print(root.right);
    }

    public static node input() {
        return input(true, 0, true);
    }

    public static node remove(node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = remove(root.left);
        root.right = remove(root.right);
        return root;
    }

    public static void main(String args[]) {
        node root = input();
        print(root);
        System.out.println(" removes leaf completly");
        node newroot = remove(root);
        print(newroot);
    }
}