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

class pair1 {
    int max;
    int min;

    pair1(int min, int max) {
        this.max = max;
        this.min = min;
    }
}

class pair {
    int height;
    int diameter;

    public pair(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}

public class diameter {
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

    public static void dup(node root) {
        if (root == null) {
            return;
        }
        node newnode = new node(root.data);
        node temp = root.left;
        root.left = newnode;
        newnode.left = temp;
        dup(temp);
        dup(root.right);

    }

    public static pair1 btreeh(node root) {
        if (root == null) {
            pair1 p = new pair1(Integer.MAX_VALUE, Integer.MIN_VALUE);
            return p;
        }
        pair1 leftc = btreeh(root.left);
        pair1 rightc = btreeh(root.right);

        int maxi = Math.max(leftc.max, Math.max(rightc.max, root.data));
        int mini = Math.min(leftc.min, Math.min(rightc.min, root.data));
        pair1 p = new pair1(mini, maxi);
        return p;
    }

    public static void print(node root) {
        Queue<node> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            node front = pendingNodes.poll();
            if (front == null) {
                System.out.println();
                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null);
                }
            } else {
                System.out.print(front.dajta + " : ");
                if (front.left != null) {
                    pendingNodes.add(front.left);
                    System.out.print("left: " + front.left.data + " ");
                }

                if (front.right != null) {
                    pendingNodes.add(front.right);
                    System.out.print(",right: " + front.right.data);
                }
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        node root = input();
        print(root);
        // dup(root);
        // print(root);
        // pair1 p = btreeh(root);
        // System.out.println(p.max + " " + p.min);
        // System.out.println(diameterbetter(root).diameter);

    }
}
