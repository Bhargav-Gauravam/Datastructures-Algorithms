public interface BinaryTreeADT{

      public BTNode createTree(int[] arr);

      public boolean insert(int data);

      public void delete(int data);

      public boolean search(int data);

      public void preorderRecursive();

      public void inorderRecursive();

      public void postorderRecursive();

      public void preorderIterative();

      public void inorderIterative();

      public void postorderIterative();

      public void levelorder();

      public void zigZagLevelorder();

      public void findLevelOfEachNode();

}
