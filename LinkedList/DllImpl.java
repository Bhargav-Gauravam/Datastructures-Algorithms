public class DllImpl implements DllADT{
    private int size;
    private DllNode headNode;
    
    
    public void insert(int data){
        DllNode newNode =new  DllNode(data);
        if(null != headNode){
            DllNode currentNode = headNode;
            while(null != currentNode.getNext()){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            newNode.setPrev(currentNode);
        }
        else {
            headNode = newNode;
        }
        size++;
    }
    
    public void insert(int data, int position){
        int count = 1;
        DllNode currentNode = headNode;
        DllNode newNode = new DllNode(data);
        if((position > 0) && (position <= size )){
            
            if(position == 1){
                newNode.setNext(currentNode);
                currentNode.setPrev(newNode);
                headNode = newNode;
            }
            else{
                while(count<(position-1)){
                    currentNode = currentNode.getNext();
                    count++;
                }
                newNode.setNext(currentNode.getNext());
                if(currentNode.getNext() != null )
                    currentNode.getNext().setPrev(newNode); 
                currentNode.setNext(newNode);
                newNode.setPrev(currentNode);
            }
            size++;
        }
    }
    
    public int delete(){
            int deletedNodeData =-1;
        if(null != headNode){
            DllNode currentNode = headNode;
            while( currentNode.getNext() != null && currentNode.getNext().getNext()!=null ){
                currentNode = currentNode.getNext();
            }
            if(currentNode.getNext() == null){
                //only one node in list
                deletedNodeData = headNode.getData();
                headNode = null;
            }
            else{
                DllNode delNode = currentNode.getNext();
                deletedNodeData = delNode.getData();
                delNode.setPrev(null);
                currentNode.setNext(null);
            }
            size--;
        }
        return deletedNodeData;
    }
    
    public int delete(int position){
        int count = 1;
        DllNode currentNode = headNode;
        int delVal=0;
        if((position > 0) && (position <= size )){
            
            if(position == 1){
                headNode = currentNode.getNext();
                headNode.setPrev(null);
                currentNode.setNext(null);
                delVal = currentNode.getData();
            }
            else{
                while(count<(position-1)){
                    currentNode = currentNode.getNext();
                    count++;
                }
                DllNode temp = currentNode.getNext();
                currentNode.setNext(temp.getNext());
                temp.getNext().setPrev(currentNode);
                temp.setNext(null);
                temp.setPrev(null);
                delVal = temp.getData();
            }
            size--;
        }
        
        return delVal;
    }
    
    public DllNode deleteList(){
        DllNode current = headNode;
        while(current != null){
            DllNode next = current.getNext();
            current.setNext(null);
            current.setPrev(null);
            current = next;
            size--;
        }
        headNode = null;
        return headNode;
    }
    
    public int get(int position){
        //int count = 1;
        DllNode currentNode = headNode;
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
        DllNode currentNode = headNode;
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
        DllNode current = headNode;
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
}