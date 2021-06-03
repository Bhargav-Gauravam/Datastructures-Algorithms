public class SllImpl implements SllADT{

    private int size;
    private SllNode headNode;
    public SllImpl(){
        super();
    }
    
    public void insert(int data){
        SllNode newNode =new  SllNode(data);
        if(null != headNode){
            SllNode currentNode = headNode;
            while(null != currentNode.getNext()){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        else {
            headNode = newNode;
        }
        size++;
    }
    
    public void insert(int data, int position){
        int count = 1;
        SllNode currentNode = headNode;
        SllNode newNode = new SllNode(data);
        if((position > 0) && (position <= size )){
            
            if(position == 1){
                newNode.setNext(currentNode);
                headNode = newNode;
            }
            else{
                while(count<(position-1)){
                    currentNode = currentNode.getNext();
                    count++;
                }
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
            size++;
        }
    }
    
    public int delete(){
            int deletedNodeData =-1;
        if(null != headNode){
            SllNode currentNode = headNode;
            while( currentNode.getNext() != null && currentNode.getNext().getNext()!=null ){
                currentNode = currentNode.getNext();
            }
            if(currentNode.getNext() == null){
                //only one node in list
                deletedNodeData = headNode.getData();
                headNode = null;
            }
            else{
                deletedNodeData = currentNode.getNext().getData();
                currentNode.setNext(null);
            }
            size--;
        }
        return deletedNodeData;
    }
    
    public int delete(int position){
        int count = 1;
        SllNode currentNode = headNode;
        int delVal=0;
        if((position > 0) && (position <= size )){
            
            if(position == 1){
                headNode = currentNode.getNext();
                currentNode.setNext(null);
                delVal = currentNode.getData();
            }
            else{
                while(count<(position-1)){
                    currentNode = currentNode.getNext();
                    count++;
                }
                SllNode temp = currentNode.getNext();
                currentNode.setNext(temp.getNext());
                temp.setNext(null);
                delVal = temp.getData();
            }
            size--;
        }
        
        return delVal;
    }
    
    public SllNode deleteList(){
        SllNode current = headNode;
        while(current != null){
            SllNode next = current.getNext();
            current.setNext(null);
            current = next;
            size--;
        }
        headNode = null;
        return headNode;
    }
    
    public int get(int position){
        //int count = 1;
        SllNode currentNode = headNode;
        int delVal=0;
        if((position > 0) && (position <= size )){
            
            for(int i =1; null != currentNode ; i++){
                if(position == i){
                    delVal = currentNode.getData();
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }
        else{
            System.out.println("Position is outside limit");
        }
        
        return delVal;
    }
    
    public int replace(int data, int position){
        int count = 1;
        int retVal = 0;
        SllNode currentNode = headNode;
        if((position > 0) && (position <= size )){
            
            if(position == 1){
                retVal = headNode.getData();
                headNode.setData(data);
            }
            else{
                while(count<(position-1)){
                    currentNode = currentNode.getNext();
                    count++;
                }
                retVal = currentNode.getNext().getData();
                currentNode.getNext().setData(data);
            }
        }
        else{
            System.out.println("Position is outside limit");
        }
        return retVal;
    }
    
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size>0)
            return false;
        else 
            return true;
    }
    
    public void traverse(){
        SllNode current = headNode;
        if(null != current){
                System.out.print(current.getData());
                current = current.getNext();
            while(null != current){
                System.out.print(" -> ");
                System.out.print(current.getData());
                current = current.getNext();
            }
            System.out.println(" ");
        }
        else{
            System.out.println("List is Empty");
        }
        
    }

    public SllNode getHead(){
    	return headNode;
    }
    
}