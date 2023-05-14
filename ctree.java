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

public class ctree {
    public static node input(boolean isroot, int data, boolean isleft) {
        if (isroot) {
            System.out.println("Enter the root: ");
        } else {
            if (isleft) {
                System.out.println("Enter the left child of " + data + " ");
            } else {
                System.out.println("Enter the right child of " + data + " ");
            }
        }
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        if (value == -1) {
            return null;
        }
        node root = new node(value);
        node leftc = input(false, value, true);
        node righc = input(false, value, false);
        root.left = leftc;
        root.right = righc;
        return root;
    }

    public static node input() {
        return input(true, 0, false);
    }

    public static void PreOrderprint(node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " : ");
        if (root.left != null)
            System.out.print(" left : " + root.left.data);
        if (root.right != null)
            System.out.print(" right : " + root.right.data);
        System.out.println();
        PreOrderprint(root.left);
        PreOrderprint(root.right);
    }

    public static void PostOrderPrint(node root) {
        if (root == null) {
            return;
        }
        if (root.left != null)
            System.out.print("left " + root.left.data);
        if (root.right != null)
            System.out.print(" right " + root.right.data);
        System.out.print(root.data);
        System.out.println();
        PostOrderPrint(root.left);
        PostOrderPrint(root.right);
    }

    public static void InorderPrint(node root) {
        if (root == null) {
            return;
        }
        if (root.left != null)
            System.out.print("left : " + root.left.data);
        System.out.print(" | " + root.data);
        if (root.right != null)
            System.out.print(" right " + root.right.data);
        System.out.println();
        InorderPrint(root.left);
        InorderPrint(root.right);
    }

    public static int countNodes(node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int sumNodes(node root) {
        if (root == null) {
            return 0;
        }
        return root.data + sumNodes(root.left) + sumNodes(root.right);
    }

    public static void main(String[] args) {

        node root = input();
        // preorder : root , left, right
        System.out.println("Pre-Order traversal ");
        PreOrderprint(root);
        // postorder : left, right, root
        System.out.println("Post Order  traversal ");
        PostOrderPrint(root);
        System.out.println("In-Order  traversal ");
        // inorder: left , root,, right
        InorderPrint(root);
        // levelorder: level wise
        System.out.println("number of nodes in this tree is " + countNodes(root));
        System.out.println("Sum of nodes is : " + sumNodes(root));
    }

}
