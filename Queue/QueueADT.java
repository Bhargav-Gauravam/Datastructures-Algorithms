public interface QueueADT{
    
    public void enQueue(int data);
    public int deQueue();
    public int front();
    public boolean isFull();
    public boolean isEmpty();
    
}