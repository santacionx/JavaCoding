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

public class bst1 {

    public static node sortedtree(int Preorder[], int Inorder[], int PStartIndex, int PEndIndex,
            int IStartIndex, int IEndIndex) {
        if (PStartIndex > PEndIndex) {
            return null;
        }
        int rootdata = Preorder[PStartIndex];
        node root = new node(rootdata);
        int rootIndex = -1;
        for (int i = IStartIndex; i <= IEndIndex; i++) {
            if (Inorder[i] == rootdata) {
                rootIndex = i;
                break;
            }
        }
        int sIndexOfPreorderLeft = PStartIndex + 1;
        int sIndexOfInorderLeft = IStartIndex;

        int eIndexOfInorderLeft = rootIndex - 1;
        int sIndexOfInorderRight = rootIndex + 1;

        int eIndexOfPreorderRight = PEndIndex;
        int eIndexOfInorderRight = IEndIndex;

        int leftsubtreelength = eIndexOfInorderLeft - sIndexOfInorderLeft + 1;

        int eIndexOfPreorderLeft = sIndexOfPreorderLeft + leftsubtreelength - 1;

        int sIndexOfPreorderRight = eIndexOfPreorderLeft + 1;

        node left = sortedtree(Preorder, Inorder, sIndexOfPreorderLeft, eIndexOfPreorderLeft, sIndexOfInorderLeft,
                eIndexOfInorderLeft);
        node right = sortedtree(Preorder, Inorder, sIndexOfPreorderRight, eIndexOfPreorderRight, sIndexOfInorderRight,
                eIndexOfInorderRight);
        root.left = left;
        root.right = right;
        return root;
    }

    public static node sortedtree(int inorder[], int preorder[]) {
        return sortedtree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

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

    public static node searchbtree(node root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            return root;
        }
        if (data > root.data) {
            searchbtree(root.right, data);
        }
        return searchbtree(root.left, data);
    }

    public static void printk(node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data < k1) {
            printk(root.right, k1, k2);
        } else if (root.data > k2) {
            printk(root.left, k1, k2);
        } else {
            System.out.print(root.data + " ");
            printk(root.left, k1, k2);
            printk(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        int inorder[] = { 4, 2, 5, 1, 3 };
        int preorder[] = { 1, 2, 4, 5, 3 };
        node root = sortedtree(inorder, preorder);
        printk(root, 0, 2);
        print(root);
        System.out.println("searching for data ");
        node rootans = searchbtree(root, 0);
        if (rootans != null) {
            System.out.println("found at " + rootans.data);
        } else {
            System.out.println("not found! ");
        }

    }
}