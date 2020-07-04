import java.util.*;

public class TstImpl{

    TstNode root;

    public TstImpl(){
        root = null;
    }

    public void insert(String text){
        if(null == text){
            return;
        }
        char[] textArr = text.toCharArray();
        if(textArr.length == 0){
            return;
        }
        root = insertText(textArr,root, 0);
    }
    private TstNode insertText(char[] arr, TstNode node, int pos){
        if(pos >= arr.length)
            return null;
        if(null == node){
            //create new node
            TstNode newNode = new TstNode(arr[pos]);
            if(pos == arr.length-1){
                newNode.isEndOfString = true;
                return newNode;
            }
            else{
                newNode.equal = insertText(arr, newNode.equal, pos+1);
            }
            return newNode;
        }
        else if(node.val == arr[pos]){
            if(pos == arr.length-1){
                if(node.isEndOfString){
                     System.out.println("String already Present");
                }
                else{
                     System.out.println("String already Present as suffix");
                     node.isEndOfString = true;
                }
                return null;
            }
            // move to next character
            return insertText(arr, node.equal, pos+1);
        }
        else if(node.val > arr[pos]){
            // add to left of node as new char to be added is lesser than current Node value
            node.left = insertText(arr, node.left, pos);
            return node;
        }
        else if(node.val < arr[pos]){
            // add to right of node as new char to be added is greater than current Node value
            node.right = insertText(arr, node.right, pos);
            return node;
        }
        return node;
    }

    public boolean isTextPresent(String text){
        return false;
    }

    // User a stack to print all the values from root to the different edge nodes
    public void traverseTst(){
        Stack<TstNode> stack = new Stack<TstNode>();
        Stack<TstNode> textStack = new Stack<TstNode>();
        //System.out.println("adding this to stack = "+root.val);
        stack.push(root);
        //System.out.println("adding this to text stack = "+root.val);
        textStack.push(root);

        while(!stack.isEmpty()){
            if(stack.peek().equal == null || stack.peek().isEndOfString){
                printStack(textStack);
            }
            if((stack.peek().left != null) && !stack.peek().left.visited ){
                stack.peek().left.visited = true;
                stack.push(stack.peek().left);
            }
            else if(stack.peek().equal != null && !stack.peek().equal.visited ){
                stack.peek().equal.visited = true;
                //System.out.println("adding this to text stack = "+stack.peek().val);
                textStack.push(stack.peek().equal);
                stack.push(stack.peek().equal);
            }
            else if(stack.peek().right != null && !stack.peek().right.visited ){
                stack.peek().right.visited = true;
                stack.push(stack.peek().equal);
            }
            else{
                if(textStack.peek() == stack.peek()){
                //System.out.println("popping this out of text stack = "+textStack.peek().val);
                    textStack.pop();
                }
                stack.pop();
            }
        }



    }

    private void printStack(Stack<TstNode> stack){
        Stack<TstNode> auxStack = new Stack<TstNode>();
        System.out.println("Pringting the word :");
        while(!stack.isEmpty()){
            auxStack.push(stack.pop());
        }
        while(!auxStack.isEmpty()){
            TstNode temp = auxStack.pop();
            temp.visited = false;
            System.out.print(temp.val);
            stack.push(temp);
        }
        System.out.println(" ");
    }

}
