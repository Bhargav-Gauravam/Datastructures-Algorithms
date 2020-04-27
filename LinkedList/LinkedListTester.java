public class LinkedListTester{
    
    public static void main(String[] args){
        /*SllImpl list = new SllImpl();
        list.insert(8);
        list.insert(3);
        list.insert(7);
        list.insert(2);
        list.insert(5);
        list.insert(1);
        list.insert(99,4);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.traverse();
        list.replace(-2, 4);
        list.traverse();
        list.deleteList();
        System.out.println(list.size());
        System.out.println(list.isEmpty());*/
        
        System.out.println("Testing Doubly Linked List");
        DllImpl list = new DllImpl();
        list.insert(8);
        list.insert(3);
        list.insert(7);
        list.insert(2);
        list.insert(5);
        list.insert(1);
        list.insert(99,4);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.traverse();
        list.replace(-2, 4);
        list.traverse();
        list.deleteList();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}