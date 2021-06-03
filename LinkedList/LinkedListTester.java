public class LinkedListTester{
    
    public static void main(String[] args){
        SllImpl listOne = new SllImpl();
        listOne.insert(3);
        listOne.insert(5);
        listOne.insert(7);
        listOne.insert(9);
        listOne.insert(11);
        listOne.traverse();
        
        /*System.out.println("Testing Doubly Linked List");
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
        System.out.println(list.isEmpty()); */

        SllImpl listTwo = new SllImpl();
        listTwo.insert(2);
        listTwo.insert(4);
        listTwo.insert(6);
        listTwo.insert(8);
        listTwo.insert(10);
        listTwo.traverse();

        SllNode mergedListNode = getMergedList(listOne, listTwo);
        traverse(mergedListNode);

    }

    public static SllNode getMergedList(SllImpl one, SllImpl two){
        SllNode newHead = null;
        SllNode headOne = one.getHead();
        SllNode headTwo = two.getHead();
        SllNode temp = null;
        while(null != headOne && null != headTwo ){
            if(headOne.getData() < headTwo.getData()){
                if(null == newHead)
                    newHead = headOne;
                temp = headOne.getNext();
                headOne.setNext(headTwo);
                headOne = temp;
            }
            else{
                if(null == newHead)
                    newHead = headTwo;
                temp = headTwo.getNext();
                headTwo.setNext(headOne);
                headTwo = temp;
            }
        }
        return newHead;
    } 

    public static void traverse(SllNode targetNode){
        if(null == targetNode)
            return;

        while(null != targetNode){
            System.out.print(targetNode.getData() + " -> ");
            targetNode = targetNode.getNext();
        }

        System.out.println(" Null ");
    }
}