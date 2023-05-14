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

public class binarytree {
    public static node input() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        node root = new node(data);
        node leftc = input();
        node rightc = input();
        root.left = leftc;
        root.right = rightc;
        return root;
    }

    public static void print(node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " :  ");
        if (root.left != null)
            System.out.print("l " + root.left.data + " ");
        if (root.right != null)
            System.out.print("r " + root.right.data);
        System.out.println();
        print(root.left);
        print(root.right);
    }

    public static node betterinput(boolean isroot, int parentdata, boolean isleft) {
        if (isroot) {
            System.out.println("enter root data ");
        } else {
            if (isleft) {
                System.out.println("enter the left child of " + parentdata);
            } else {
                System.out.println("enter the right child of " + parentdata);
            }
        }
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        node root = new node(data);
        node leftc = betterinput(false, data, true);
        node rightc = betterinput(false, data, false);
        root.left = leftc;
        root.right = rightc;
        return root;

    }

    public static void main(String args[]) {
        node root = betterinput(true, 0, false);
        print(root);
    }
}