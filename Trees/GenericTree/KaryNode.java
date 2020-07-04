public class KaryNode{
    int data;
    KaryNode[] children;
    public KaryNode(int data, int k){
        this.data = data;
        children = new KaryNode[k];
    }
}
