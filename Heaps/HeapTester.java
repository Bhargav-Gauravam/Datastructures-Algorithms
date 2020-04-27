public class HeapTester{
    
    public static void main(String[] args){
        
           int[] arr = {1,7,3,8,2,9,0,3};
       int firstIntNode = arr.length/2;
       for(int i=firstIntNode ; i>-1; i--){
          arr =   heapify(arr, i );
       }
           
        System.out.print("[ ");
        for(int i=0; i< arr.length; i++){
            System.out.print(" "+arr[i]);
        }
          System.out.print(" ]");
    }
    
  static int[]  heapify(int[] arr, int index){
        int parent = arr[index];
        int left = -1;
        int right = -1;
        if( (arr.length-1) >= ((2*index) +1) ){
            left = arr[ (2*index) +1 ];
        }
        if ((arr.length-1) >= ((2*index) +2) ){
            right = arr[(2*index)+2];
        }
        int largest = getMax(parent, left, right);
        if(largest == left){
            arr[index] = arr[(2*index)+1];
            arr[(2*index)+1] = parent;
            heapify(arr, (2*index)+1);
        }
        else if(largest == right ){
            //swap(parent, (2*index)+2 );
            arr[index] = arr[(2*index)+2];
            arr[(2*index)+2] = parent;
            heapify(arr, (2*index)+2);
        }
        else{
            // dont swap and dont call heapify
        }
      return arr;
    }
    
    static int getMax(int a, int b, int c){
        //System.out.println("get max of a = " + a + " b = "+b+" and c  = "+c);
        if(a > b){
            if( a > c){
                return a;
            }
            else{
                return c;
            }
        }
        else {
            if( b > c){
                return b;
            }
            else{
                return c;
            }
        }
    }
    
}