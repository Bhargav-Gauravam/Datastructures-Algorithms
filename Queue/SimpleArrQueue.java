public class SimpleArrQueue{
    
    int capacity;
    int front;
    int rear;
    int[] arr;
    
    public SimpleArrQueue(int size){
        this.capacity = size;
        arr = new int[size];
        front=-1;
        rear=-1;
    }
    
    public void enQueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else{
            System.out.println("Enqueuing data  rear = "+rear + "  (rear+1)%capacity = "+((rear+1)%capacity ) );
            rear = (rear +1) % capacity;
            arr[rear] = data;
            if(front == -1){
                front = rear;
            }
        }
    }
    
    public int deQueue(){
        int data = -999;
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        else{
            data = arr[front];
            if(front == rear){
                front = rear -1;
            }
            else{
                front = (front +1) % capacity;
            }
        }
        return data;
    }
    public int front(){
        if(!isEmpty()){
            return arr[front];
        }
        return -1;
    }
    
    public boolean isFull(){
        return ((rear+1)% capacity == front);
    }
    
    public boolean isEmpty(){
        return front==-1;
    }
    
    public void displayQueue(){
        System.out.print("[ ");
        for(int i=0; i<arr.length -1;i++){
            System.out.print(arr[i] + " , ");
        }
        System.out.print(arr[arr.length-1] + " ]");
    }
    
}