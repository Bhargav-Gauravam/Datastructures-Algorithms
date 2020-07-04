public class KaryImpl{
    Kary root = null;
    public void createTree(int[] val, int k){
        if(null == val || val.length==0)
            return;
        root = new Kary(val[0],k);
        Queue<Kary> q = new LinkedLIst<Kary>();
        q.add(root);

        for(int i=0; i<val.length; i++){
            Kary node = q.remove();
            for(int j=0; j<k && j<val.length; j++){
                if((k*i)+(j+1) < val.length){
                    node.children[j] = new Kary(val[(k*i)+(j+1)], k);
                    q.add(node.children[j]);
                }
            }
        }
    }
}
