import java.util.*;

class breturn {
    int maximum;
    int minimum;
    boolean isbst;

    public breturn(int maximum, int minimum, boolean isbst) {
        this.maximum = maximum;
        this.minimum = minimum;
        this.isbst = isbst;
    }
}

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

public class checkbst {
    public static node input() {
        System.out.println("enter the root : ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Queue<node> pendingNodes = new LinkedList<>();
        node root = new node(data);
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            node front = pendingNodes.poll();
            System.out.println("enter the left child" + front.data);
            int leftdata = sc.nextInt();
            if (leftdata != -1) {
                node leftchild = new node(leftdata);
                pendingNodes.add(leftchild);
                front.left = leftchild;
            }
            System.out.println("enter the right child" + front.data);
            int rightdata = sc.nextInt();
            if (rightdata != -1) {
                node rightchild = new node(rightdata);
                pendingNodes.add(rightchild);
                front.right = rightchild;
            }
        }
        return root;
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

    // public static int maximum(node root) {
    // if (root == null) {
    // return Integer.MIN_VALUE;
    // }
    // int leftmax = maximum(root.left);
    // int rightmax = maximum(root.right);
    // return Math.max(root.data, Math.max(leftmax, rightmax));
    // }

    // public static int minimum(node root) {
    // if (root == null) {
    // return Integer.MAX_VALUE;

    // }
    // int leftmin = minimum(root.left);
    // int rightmin = minimum(root.right);
    // return Math.min(root.data, Math.min(leftmin, rightmin));
    // }

    // public static boolean isbst(node root) {
    // if (root == null) {
    // return true;
    // }
    // int leftmax = maximum(root.left);
    // if (leftmax >= root.data) {
    // return false;
    // }
    // int rightmin = minimum(root.right);
    // if (rightmin < root.data) {
    // return false;
    // }
    // return isbst(root.left) && isbst(root.right);

    // }

    public static breturn helper(node root) {

        if (root == null) {
            breturn ans = new breturn(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            return ans;
        }
        breturn leftc = helper(root.left);
        breturn rightc = helper(root.right);
        int minimum = Math.min(root.data, Math.min(leftc.minimum, rightc.minimum));
        int maximum = Math.max(root.data, Math.max(leftc.maximum, rightc.maximum));
        boolean isbst = true;
        if (leftc.maximum >= root.data) {
            isbst = false;
        }
        if (rightc.minimum < root.data) {
            isbst = true;
        }
        if (!leftc.isbst) {
            isbst = false;
        }
        if (!rightc.isbst) {
            isbst = false;
        }
        breturn ans = new breturn(maximum, minimum, isbst);
        return ans;

    }

    public static void main(String args[]) {
        node root = input();
        print(root);
        breturn p = helper(root);
        System.out.println(p.isbst);

    }
}
