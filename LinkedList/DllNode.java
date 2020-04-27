class DllNode{
    private int data;
    private DllNode next;
    private DllNode prev;
    
    public DllNode(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setNext(DllNode next){
        this.next = next;
    }
    public DllNode getNext(){
        return next;
    }
    public void setPrev(DllNode prev){
        this.prev = prev;
    }
    public DllNode getPrev(){
        return prev;
    }
    
}