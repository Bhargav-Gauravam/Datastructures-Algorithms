public interface BinaryTreeADT{

      public BTNode createTree(int[] arr);

      public boolean insert(int data);

      public boolean delete(int data);

      public boolean search(int data);

      public void preorderRecursive();

      public void inorderRecursive();

      public void postorderRecursive();

      public void preorderIterative();

      public void inorderIterative();

      public void postorderIterative();

      public void levelorder();

      public void zigZagLevelorder();

}
