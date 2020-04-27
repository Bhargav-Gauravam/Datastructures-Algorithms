public class QueueTester{
    
    public static void main(String[] args){
        SimpleArrQueue que = new SimpleArrQueue(8);
        que.enQueue(7);
        que.enQueue(6);
        que.enQueue(5);
        que.enQueue(4);
        que.enQueue(3);
        que.enQueue(2);
        que.enQueue(1);
        que.enQueue(0);
        que.displayQueue();
        System.out.println(" ");
        que.deQueue();
        que.deQueue();
        que.deQueue();
        que.displayQueue();
        System.out.println(" ");
        que.enQueue(2);
        que.enQueue(1);
        que.enQueue(0);
        que.displayQueue();
    }
}