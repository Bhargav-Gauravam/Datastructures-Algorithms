public class BinaryTreeTester{

    public static void main(String[] args){
        System.out.println("This is a Binary Tree Tester Class");

        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        BTNode root = binaryTree.createTree(arr);
        System.out.println(root.data);
        System.out.println("Print Level Order ");
        binaryTree.levelorder();
        System.out.println("Print Pre-Order Recursive ");
        binaryTree.preorderRecursive();
        System.out.println("Print In-Order Recursive ");
        binaryTree.inorderRecursive();
        System.out.println("Print Post-Order Recursive ");
        binaryTree.postorderRecursive();

    }

}
