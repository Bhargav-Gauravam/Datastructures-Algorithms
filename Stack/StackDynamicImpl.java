public class StackDynamicImpl implements StackADT {
 
    private int size;
    private int[] stack;
    
    public StackDynamicImpl(int capacity){
        size = -1;
        stack = new int[capacity];
    }
    
    public void push(int data){
        if(size == (stack.length -1)) {
            doubleStackCapacity();
        }
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
    
    public void doubleStackCapacity(){
        int doubleSize = size*2;
        int[] oldStack = stack;
        stack = new int[doubleSize];
        for(int i=0; i<oldStack.length; i++){
            stack[i] = oldStack[i];
        }
    }
    
}