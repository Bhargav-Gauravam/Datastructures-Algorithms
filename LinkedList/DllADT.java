interface DllADT{


    public void insert(int data);
    public void insert(int data, int position);
    public int delete();
    public int delete(int position);
    public DllNode deleteList();
    public int get(int position);
    public int replace(int data, int position);
    public int size();
    public boolean isEmpty();
    public void traverse();
    
    
}