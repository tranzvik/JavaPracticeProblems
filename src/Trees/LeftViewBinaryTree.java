package Trees;

public class LeftViewBinaryTree {
 static int  maxHeight=0;

 public  static void demoProblems() {
     printLeftViewInitialise();
 }

 public static void printLeftViewInitialise() {

      /*
                        2
                      /    \
                     7       5
                   /  \        \
                  2    6        9
                      / \      /
                     5  11    4
                     output: 2 7 2 5
         */

     Node root = new Node(2);
     root.left = new Node(7);
     root.right = new Node(5);

     root.left.left = new Node(2);
     root.left.right = new Node(6);

     //root.right.left = new Node(5);
     root.right.right = new Node(9);

     root.left.right.left = new Node(5);
     root.left.right.right = new Node(11);

     root.right.right.left = new Node(4);
     printLeftView(root,0);
 }

    public static void printLeftView(Node root, int height) {
        if (root != null) {
            height++;
            if(height>maxHeight) {
                System.out.println(root.data);
            }
            if (root.left != null) {
                System.out.println("ht:"+height);
                printLeftView(root.left,height);

            }
            if(height>maxHeight){
                maxHeight=height;
            }
            if(root.right!=null) {
                //System.out.println(root);
                printLeftView(root.right,height);
            }
        }
    }
}
