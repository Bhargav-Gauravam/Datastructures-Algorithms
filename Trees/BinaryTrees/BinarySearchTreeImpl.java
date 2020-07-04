public class BinarySearchTreeImpl {

    BTNode root = null;

    // given a sorted array convert to BST
    public BTNode createBst(int[] arr){
        if(arr.length == 0)
            return null;
        if(arr.length == 1){
            return new BTNode(arr[0]);
        }
        int midIndex = (arr.length-1)/2;
        BTNode node = new BTNode(arr[midIndex]);
        node.left = createBst(getLeftSubTree(arr, midIndex));
        node.right = createBst(getRightSubTree(arr, midIndex));
        if(root == null)
            root = node;

        return node;
    }
    public int[] getLeftSubTree(int[] fullArr, int midIndex){
        int[] leftArr = new int[midIndex];
        for(int i=0; i<leftArr.length; i++){
            leftArr[i] = fullArr[i];
        }
        return leftArr;
    }
    public int[] getRightSubTree(int[] fullArr, int midIndex){
        int[] rightArr = new int[fullArr.length - midIndex - 1];
        for(int i=0; i<rightArr.length; i++){
            rightArr[i] = fullArr[i+midIndex+1];
        }
        return rightArr;
    }

    public BTNode getRoot(){
        return root;
    }

    // Given a sorted linked list convert to BST
    public BTNode createBstFrmSll(SllNode head){
        if(null == head)
            return null;
        if(null == head.getNext())
            return new BTNode(head.getData());

        SllNode middle = getMiddle(head);
        BTNode node = new BTNode(middle.getData());
        node.left = createBstFrmSll(head);
        SllNode rightNode = middle.getNext();
        middle.setNext(null);
        node.right = createBstFrmSll(rightNode);
        return node;
    }
    public SllNode getMiddle(SllNode newHead){
        if(null == newHead)
            return null;
        if(null == newHead.getNext())
            return newHead;
        // 2 pointer approach
        SllNode slow = newHead;
        SllNode fast = newHead;
        SllNode prev = null;
        while(fast != null && fast.getNext() != null ){
            prev = slow;
            slow = slow.getNext();
            fast = fast.getNext();
            if(fast != null)
                fast = fast.getNext();
        }
        if(null != prev)
            prev.setNext(null);
        return slow;
    }

    // Given preorder and inorder , construct a Binary tree
    public BTNode createBstPreInOrder(int[] preOrder, int[] inOrder){
        // Algorithm
        // 1. take 1st element of preOrder and find that in inOrder
        // 2. create the current node and divide the list to left and right subtrees
        // 3. recurse on these lists

        if(preOrder == null || inOrder == null || preOrder.length==0 || inOrder.length==0)
            return null;
        if(inOrder.length == 1)
            return new BTNode(inOrder[0]);

        BTNode node = new BTNode(preOrder[0]);
        int rootInorderIndex = -1;
        for(int index =0; index<inOrder.length; index++){
            if(preOrder[0] == inOrder[index]){
                rootInorderIndex = index;
                break;
            }
        }
        int[] leftPreorder = new int[rootInorderIndex];
        int[] rightPreorder = new int[inOrder.length - rootInorderIndex-1];
        int[] leftInorder = new int[rootInorderIndex];
        int[] rightInorder = new int[inOrder.length - rootInorderIndex-1];

        // populate left preorder array
        for(int i =0; i<leftPreorder.length; i++){
            leftPreorder[i] = preOrder[i+1];
            leftInorder[i] = inOrder[i];
        }
        // populate right preorder array
        for(int i =0; i<rightPreorder.length; i++){
            rightPreorder[i] = preOrder[leftPreorder.length+i+1];
            rightInorder[i] = inOrder[rootInorderIndex+i+1];
        }

        node.left = createBstPreInOrder(leftPreorder, leftInorder);
        node.right = createBstPreInOrder(rightPreorder, rightInorder);

        return node;
    }
}
