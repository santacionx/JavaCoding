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

public class levelwiseinput {
    public static node input() {
        System.out.println("enter the root: ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        node root = new node(data);
        Queue<node> pendingnode = new LinkedList<node>();
        pendingnode.add(root);
        while (!pendingnode.isEmpty()) {
            node front = pendingnode.poll();
            System.out.println("ente1r the left child of " + front.data);
            int left = sc.nextInt();
            if (left != -1) {
                node leftchild = new node(left);
                front.left = leftchild;
                pendingnode.add(leftchild);
            }
            System.out.println("enter the right child of " + front.data);
            int right = sc.nextInt();
            if (right != -1) {
                node rightchild = new node(right);
                front.right = rightchild;
                pendingnode.add(rightchild);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        node root = input();
        print(root);

    }
}
