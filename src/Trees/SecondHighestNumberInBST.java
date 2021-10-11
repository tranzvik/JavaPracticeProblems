package Trees;

import java.util.Collections;
import java.util.List;

public class SecondHighestNumberInBST {

    static int counter=0;

    public static void treeTraversalsInBST() {
        Node root = createBST(Collections.emptyList());
        secondHighestNumberInBST(root);
    }

    /**
     * secondHighestNumberInBST
     */
    public static void secondHighestNumberInBST(Node root) {
        if(root!=null) {
            if(root.right!=null) {
                secondHighestNumberInBST(root.right);
            }
            counter++;
            if(counter==2){
                System.out.println("Second highest number is:"+ root.data);
                return;
            }
            if(root.left!=null){

                secondHighestNumberInBST(root.left);
            }
        }
    }

    //provide nos in order ...tree height=2
    public static Node createBST(List<Integer> numList) {
        //Initializing Tree
        /*
                        6
                      /   \
                     4     8
                   /  \   /  \3
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
}
