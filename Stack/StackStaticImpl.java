public class StackStaticImpl implements StackADT {
 
    private int size;
    private int[] stack;
    
    public StackStaticImpl(int capacity){
        size = -1;
        stack = new int[capacity];
    }
    
    public void push(int data){
        if(size == (stack.length -1)) {
            System.out.println("Stack is full , can not perform push operation");
            return;
        }
        System.out.println("This is not called if, stack is full");
        stack[++size] = data;
    }
    
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[size--];
    }
    
    public int top(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[size];
    }
    
    public boolean isEmpty(){
         return (-1 == size);
    }
    
    public int size(){
        return (size+1);
    }
    
}