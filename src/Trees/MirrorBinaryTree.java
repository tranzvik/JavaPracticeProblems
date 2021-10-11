package Trees;

import java.util.Arrays;
import java.util.List;

public class MirrorBinaryTree {

    public static void solveMirroringBT() {

        Node root = createBST(Arrays.asList());

        printMirrorOfBinaryTree(root);
        inOrderTraversal(root);
    }

    public static Node createBST(List<Integer> numList) {
        //Initializing Tree
        /*
                        6
                      /   \
                     4     8
                   /  \   /  \
                  2    5  7   9

         */
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);

        root.left.left = new Node(2);
        root.left.right = new Node(5);

        root.right.left = new Node(7);
        root.right.right = new Node(9);

        return root;
    }


    public static Node printMirrorOfBinaryTree(Node root) {
        Node left =null;
        Node right = null;
        Node temp=null;
        if(root!=null){
           left = printMirrorOfBinaryTree(root.left);
           right = printMirrorOfBinaryTree(root.right);
           root.right = left;
           root.left= right;
        }
        return root;

    }

    public static void inOrderTraversal(Node root) {
        if(root!=null){
            if(root.left!=null)
            inOrderTraversal(root.left);
            System.out.println(root.data+" ");
            if(root.right!=null)
            inOrderTraversal(root.right);
        }
    }


}
