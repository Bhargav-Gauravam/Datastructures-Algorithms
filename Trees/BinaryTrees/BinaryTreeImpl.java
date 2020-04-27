import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeImpl implements BinaryTreeADT{

        BTNode root;

        public BinaryTreeImpl(){
          root = null;
        }

        /*
        logic to create a Tree ,
        root = i
        root.left = 2i+1
        root.right = 2i+2
        */
        public BTNode createTree(int[] arr){
          if(null == arr || arr.length == 0)
              return root;
          // we can optimize this loop, by replacing i<arr.length with
          // (2*i+1) < arr.length
          root = createTree(arr,0);
          return root;
        }

        private BTNode createTree(int[] arr, int i){
          if(i >= arr.length)
              return null;
          BTNode base = new BTNode(arr[i]);
          base.left = createTree(arr, (2*i)+1 );
          base.right = createTree(arr,(2*i)+2 );
          return base;
        }

        public boolean insert(int data){
          BTNode newNode = new BTNode(data);
          if(root == null)
              root = newNode;
          else{
            Queue<BTNode> que = new LinkedList<BTNode>();
            que.add(root);
            while(!que.isEmpty()){
              BTNode node = que.remove();
              if(node.left == null){
                  node.left = newNode;
                  break;
              }
              else{
                que.add(node.left);
              }
              if(node.right == null){
                node.right = newNode;
                break;
              }
              else{
                que.add(node.right);
              }
            }
          }
          return true;
        }

        public boolean delete(int data){
          return true;
        }

        public boolean search(int data){
          return true;
        }

        public void preorderRecursive(){
          if(root == null)
              return;
          System.out.print("[");
          preorderRecursive(root);
          System.out.println(" ]");
        }
        private void preorderRecursive(BTNode node){
          if(null == node)
              return;
          System.out.print(" "+node.data);
          preorderRecursive(node.left);
          preorderRecursive(node.right);
        }

        public void inorderRecursive(){
            if(root == null)
                return;
            System.out.print("[");
            inorderRecursive(root);
            System.out.println(" ]");
        }
        private void inorderRecursive(BTNode node){
            if(null == node)
                return;
            inorderRecursive(node.left);
            System.out.print(" "+node.data);
            inorderRecursive(node.right);
        }

        public void postorderRecursive(){
            if(root == null)
                return;
            System.out.print("[");
            postorderRecursive(root);
            System.out.println(" ]");
          }
          private void postorderRecursive(BTNode node){
            if(null == node)
                return;
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(" "+node.data);
          }

        public void preorderIterative(){

        }

        public void inorderIterative(){

        }

        public void postorderIterative(){

        }


        public void levelorder(){
          if(root == null)
              return;
          Queue<BTNode> que = new LinkedList<BTNode>();
          que.add(root);
          System.out.print("[ ");
          while(!que.isEmpty()){
            BTNode node = que.remove();
            System.out.print( node.data + " ");
            if(node.left != null)
                que.add(node.left);
            if(node.right != null)
                que.add(node.right);
          }
          System.out.println("]");
        }

        public void zigZagLevelorder(){

        }

}
