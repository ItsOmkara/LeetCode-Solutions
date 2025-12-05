package BinaryTree;

public class Node {
    int data;
    Node right,left;

    Node(int val){
        data = val;
        right = left = null;
    }

    public class TreeHeight{
        static int height(Node root) {
            if (root == null)
                return 0;

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return 1 + Math.max(leftHeight, rightHeight);
        }
        public static void main(String[] args) {
            // Build tree
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            System.out.println("Height of tree: " + height(root));
        }
    }
}

