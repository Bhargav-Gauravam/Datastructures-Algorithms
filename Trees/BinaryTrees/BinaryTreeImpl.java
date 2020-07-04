import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

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

        public void delete(int data){
            if(root == null)
                return;
            root = deleteNode(root, data);
            System.out.println("root val = "+root.data);
            System.out.println("root left val = "+root.left.data);
            System.out.println("root right val = "+root.right.data);

        }

        private BTNode deleteNode(BTNode curNode, int data){
            if(curNode == null)
                return null;
            if(data == curNode.data){
                if(curNode.right != null){
                    BTNode newNode = getSmallestNode(curNode.right);
                    if(newNode != curNode.right)
                        newNode.right = curNode.right;
                    newNode.left = curNode.left;
                    curNode.right = null;
                    curNode.left = null;
                    return newNode;
                }
                else if(curNode.left != null){
                    BTNode newNode = getLargestNode(curNode.left);
                    newNode.right = curNode.right;
                    if(newNode != curNode.left)
                        newNode.left = curNode.left;
                    curNode.right = null;
                    curNode.left = null;
                    return newNode;
                }
                else{
                    return null;
                }
            }
            curNode.left = deleteNode(curNode.left, data);
            curNode.right = deleteNode(curNode.right, data);
            return curNode;
        }

        private BTNode getSmallestNode(BTNode node){
            if(node == null)
                return node;
            if(node.left == null)
                return node;
            BTNode leftMost = getSmallestNode(node.left);
            if(node.left == leftMost){
                node.left = leftMost.right;
                leftMost.right = null;
            }
            return leftMost;
        }

        private BTNode getLargestNode(BTNode node){
            if(node == null)
                return node;
            if(node.right == null)
                return node;
            BTNode rightMost = getLargestNode(node.right);
            if(root.right == rightMost){
                root.right = rightMost.right;
                rightMost.right = null;
            }
            return rightMost;
        }

        public boolean search(int data){

          return search(root,data);
        }

        public boolean search(BTNode node, int data){
            if(node == null)
                return false;
            if(node.data == data)
                return true;
            return search(node.left, data) || search(node.right, data);
        }

        public void preorderRecursive(){
          if(root == null)
              return;
          System.out.print("[");
          preorderRecursive(root);
          System.out.println(" ]");
        }

        public void preorderRecursive(BTNode node){
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

        public void inorderRecursive(BTNode node){
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

        public void postorderRecursive(BTNode node){
          if(null == node)
              return;
          postorderRecursive(node.left);
          postorderRecursive(node.right);
          System.out.print(" "+node.data);
        }

        public void preorderIterative(){
            Stack<BTNode> stack = new Stack<BTNode>();
            BTNode node = root;
            System.out.print("[ ");
            while(true){
                while(node != null){
                    System.out.print(node.data+ " ");
                    stack.push(node);
                    node = node.left;
                }
                if(stack.isEmpty())
                    break;
               node = stack.pop();
               node = node.right;
            }
            System.out.println("]");
        }

        public void inorderIterative(){
            Stack<BTNode> stack = new Stack<BTNode>();
            BTNode node = root;
            System.out.print("[ ");
             while(true){
                 while(node!=null){
                     stack.push(node);
                     node = node.left;
                 }
                 if(stack.isEmpty())
                     break;
                 node = stack.pop();
                 System.out.print(node.data+" ");
                 node = node.right;
             }
             System.out.println("]");
        }

        public void postorderIterative(){
            Stack<BTNode> stack = new Stack<BTNode>();
            BTNode node = root;
            System.out.print("[ ");
            while(true){
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
                if(stack.isEmpty())
                    break;
                if(stack.peek().right != null)
                    node = stack.peek().right;
                else{
                    node = stack.pop();
                    while(!stack.isEmpty() && (stack.peek().right==node) ){
                        System.out.print(node.data+" ");
                        node = stack.pop();
                    }
                    System.out.print(node.data+" ");
                    node = null;
                }
            }
            System.out.println("]");
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
        public void levelOrder(BTNode node){
            root = node;
            levelorder();
        }

        public void zigZagLevelorder(){

            BTNode node = root;
            Stack<BTNode> even = new Stack<BTNode>();
            Stack<BTNode> odd = new Stack<BTNode>();
            even.push(node);
            System.out.print("[ ");
            while((!even.isEmpty()) || (!odd.isEmpty())){
                if(!even.isEmpty()){
                    while(!even.isEmpty()){
                        BTNode cur = even.pop();
                        if(null != cur.left)
                            odd.push(cur.left);
                        if(null != cur.right)
                            odd.push(cur.right);
                        System.out.print(cur.data+" ");
                    }
                }
                else{
                    while(!odd.isEmpty()){
                        BTNode cur = odd.pop();
                        System.out.print(cur.data+" ");
                        even.push(cur);
                    }
                    while(!even.isEmpty()){
                        BTNode cur = even.pop();
                        if(null != cur.left)
                            odd.push(cur.left);
                        if(null != cur.right)
                            odd.push(cur.right);
                    }
                    while(!odd.isEmpty()){
                        even.push(odd.pop());
                    }
                }
            }
            System.out.println("]");
        }

        public int sizeOfTree(){
            return nodeSize(root);
        }

        public int nodeSize(BTNode node){
            if(node == null)
                return 0;
            return nodeSize(node.left) + nodeSize(node.right) + 1;
        }

        public int sumTree(BTNode node){

            if(null == root)
                return 0;
            // left sub tree sum
            int leftSubTreeSum = sumTree(node.left);
            // right sub tree sum
            int rightSubTreeSum = sumTree(node.right);
            // updating value of current node
            return node.data + leftSubTreeSum + rightSubTreeSum;
        }

        public boolean subtreeOfTree(BTNode root, BTNode subRoot){
               return true;
        }


      public void findLevelOfEachNode(){

      }
}
