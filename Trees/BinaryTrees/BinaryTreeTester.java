public class BinaryTreeTester{

    public static void main(String[] args){
        System.out.println("This is a Binary Tree Tester Class");

        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        // BTNode root = binaryTree.createTree(arr);
        // System.out.println(root.data);
        // System.out.println("Print Level Order ");
        // binaryTree.levelorder();
        // System.out.println("Print Pre-Order Recursive ");
        // binaryTree.preorderRecursive();
        // System.out.println("Print Pre-Order Iterative ");
        // binaryTree.preorderIterative();
        // System.out.println("Print In-Order Recursive ");
        // binaryTree.inorderRecursive();
        // System.out.println("Print In-Order Iterative ");
        // binaryTree.inorderIterative();
        // System.out.println("Print Post-Order Recursive ");
        // binaryTree.postorderRecursive();
        // System.out.println("Print Post-Order Iterative ");
        // binaryTree.postorderIterative();
        // System.out.println("Print Level Order ");
        // binaryTree.levelorder();
        // System.out.println("Print Zig-Zag Level Order ");
        // binaryTree.zigZagLevelorder();
        // System.out.println(binaryTree.search(4));
        // System.out.println(binaryTree.search(10));


        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        BTNode root = binarySearchTree.createBst(arr);

        // System.out.println("Print In-Order Recursive ");
        // binaryTree.inorderRecursive(root);
        // System.out.println(" ");
        // System.out.println("Print Pre-Order Recursive ");
        // binaryTree.preorderRecursive(root);
        // System.out.println(" ");
        // System.out.println("Print Level Order ");
        // binaryTree.levelOrder(root);
        // System.out.println(" ");

        // SllImpl sll = new SllImpl();
        // sll.insert(1);
        // sll.insert(2);
        // sll.insert(3);
        // sll.insert(4);
        // sll.insert(5);
        // sll.insert(6);
        // sll.insert(7);
        // sll.traverse();


        //root = binarySearchTree.createBstFrmSll(sll.getHead());

        int[] inorder = {1,2,3,4,5,6,7,8,9,10,11};
        int[] preorder = {7,4,2,1,3,5,6,9,8,11,10};

        root = binarySearchTree.createBstPreInOrder(preorder, inorder);
        System.out.println("Print Level Order ");
        binaryTree.levelOrder(root);
        System.out.println(" ");
        System.out.println("Print In-Order Recursivje ");
        binaryTree.inorderRecursive(root);
        System.out.println(" ");
        System.out.println("Print Pre-Order Recursive ");
        binaryTree.preorderRecursive(root);
        System.out.println(" ");
        System.out.println("Print Post-Order Recursive ");
        binaryTree.postorderRecursive(root);
        System.out.println(" ");

    }

}
