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

public class constBSTSortedArray {

    public static void print(node root) {
        Queue<node> penddingNodes = new LinkedList<>();
        penddingNodes.add(root);
        while (!penddingNodes.isEmpty()) {
            node front = penddingNodes.poll();
            if (front == null) {
                System.out.println();
                if (!penddingNodes.isEmpty()) {
                    penddingNodes.add(null);
                }
            } else {
                System.out.print(front.data + " : ");
                if (front.left != null) {
                    penddingNodes.add(front.left);
                    System.out.print(" left : " + front.left.data);
                }
                if (front.right != null) {
                    penddingNodes.add(front.right);
                    System.out.print(" right : " + front.right.data);
                }
                System.out.println();
            }
        }
    }

    private static node bst(int a[], int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;
        node root = new node(a[mid]);
        root.left = bst(a, s, mid - 1);
        root.right = bst(a, mid + 1, e);
        return root;

    }

    public static node bst(int a[], int n) {
        return bst(a, 0, n - 1);
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        node root = bst(array, array.length);
        print(root);

    }
}