public class StackLinkedListImpl implements StackADT{
    
    int size;
    StackNode head;
    StackNode min;
    StackNode max;
    
    public void StackLinkedListImpl(){
        size =0;
        head = null;
        min = null;
        max = null;
    }
    
    public void push(int data){
        StackNode newNode = new StackNode(data);
        if(null == head){
            StackNode minNode = new StackNode(data);
            StackNode maxNode = new StackNode(data);
            head = newNode;
            min = minNode;
            max = maxNode;
            size++;
            return;
        }
        
        if(data <= min.data){
            StackNode minNode = new StackNode(data);
            minNode.next = min;
            min = minNode;
        }
        if(data >= max.data){
            StackNode maxNode = new StackNode(data);
            maxNode.next = max;
            max = maxNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public int pop(){
        if(head == null){
            System.out.println("Cant pop on an empty stack");
            return -1;
        }
        // pop min stack 
        if(head.data == min.data){
            StackNode temp = min.next;
            min.next = null;
            min = temp;
        }
        // pop max stack
        if(head.data == max.data){
            StackNode temp = max.next;
            max.next = null;
            max = temp;
        }
        int val = head.data;
        StackNode temp = head.next;
        head.next = null;
        head = temp;
        size--;
        return val;
    }
    
    public int top(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public int size(){
        return size;
    }
    
    // Auxillary methods
    
    public int getMin(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return min.data;
    }
    
    public int getMax(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return max.data;
    }
}