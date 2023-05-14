
import java.util.*;

class breturn {
    int maxi;
    int mini;
    boolean isbst;

    breturn(int mini, int maxi, boolean isbst) {
        this.maxi = maxi;
        this.mini = mini;
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

public class helpbst {

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

    public static breturn helper(node root) {

        if (root == null) {
            breturn ans = new breturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }
        breturn leftc = helper(root.left);
        breturn rightc = helper(root.right);
        int mini = Math.min(root.data, Math.min(leftc.mini, rightc.mini));
        int maxi = Math.max(root.data, Math.max(leftc.maxi, rightc.maxi));
        boolean isbst = true;
        if (leftc.maxi >= root.data) {
            isbst = false;
        }
        if (rightc.mini < root.data) {
            isbst = false;
        }
        if (!leftc.isbst) {
            isbst = false;
        }
        if (!rightc.isbst) {
            isbst = false;
        }
        breturn ans = new breturn(maxi, mini, isbst);
        return ans;

    }

    public static void main(String args[]) {
        node root = input();
        // print(root);
        breturn p = helper(root);
        System.out.println(p.isbst);

    }
}
