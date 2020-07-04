public class MaxHeapImpl {

    ArrayList<Integer> maxHeap;


    public HeapImpl(){
        maxHeap = new ArrayList<Integer>();
    }

    /*
    Algorithm
    1. Add the new data to end of array
    2. Percolate up till parent is less than the current value
    */
    public void insertInMaxHeap(int data){
        maxHeap.add(data);
        percolateUp(maxHeap, maxHeap.size()-1);
    }
    public void percolateUp(List<Integer> heap, int childIndex){
        if( (childIndex < 1) || (childIndex > heap.size()-1))
            return;
        // Insertion would have happened in the first non leaf node
        int insertedItem = heap.get(childIndex);
        int parentIndex = (childIndex/2);
        if(heap.get(parentIndex) < insertedItem ){
            // swap parent and child
            heap.set(childIndex, heap.get(parentIndex));
            heap.set( parentIndex , insertedItem);
            percolateUp(heap, parentIndex );
        }
    }

    /*
    Algorithm
    1. Replace the value at index 0 with the value at last index
    2. Remove the last index
    3. Percolate down on the root
    */
    public void deleteRootFrmMaxHeap(){
        if( (null != maxHeap) && ( maxHeap.size() < 2))
            return;
        // 1. Replace the value at index 0 with the value at last index
        int tempVal = maxHeap.get(0);
        maxHeap.set(0, maxHeap.get(maxHeap.size()-1));
        maxHeap.set(maxHeap.size()-1, tempVal);
        // 2. Remove the last index
        maxHeap.remove(maxHeap.size()-1);
        // 3. Percolate down on the root
        percolateDown(maxHeap, 0);
    }
    public void percolateDown(List<Integer> heap, int parentIndex){
        if(parentIndex > heap.size()-1  || parentIndex < 0 || ((parentIndex*2)+1 > (heap.size()-1 )))
            return;

        // find the max amoung all 3 nodes, parent, left and right and swap
        int rightChildVal = (parentIndex*2)+2 < heap.size() ? heap.get((parentIndex*2)+2) : Integer.MIN_VALUE;
        int largest = getMax(heap.get(parentIndex), heap.get((parentIndex*2)+1), rightChildVal);
        if(largest == heap.get((parentIndex*2)+1)){
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, largest);
            heap.set((parentIndex*2)+1, temp);
            percolateDown(heap, (parentIndex*2)+1);
        }
        else if(largest == heap.get((parentIndex*2)+2)){
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, largest);
            heap.set((parentIndex*2)+2, temp);
            percolateDown(heap, (parentIndex*2)+2);
        }
        else{
            // parent is the largest and the subtree is heapified
            return;
        }

    }

    /*
    Algorithm
    1. Identify the first non-leaf node and percolate percolateDown
    2. repeat step 1 for all the data before first non leaf node
    3. We will end up with max/min heap
    */
    public int[] maxHepifyUnsortedArr(int[] arr){
        if(null==arr || arr.length<=1)
            return arr;
        int[] heap = arr;
        for(int i=((arr.length)/2)-1; i>=0; i--){
            heap = percolateDown(heap, i);
        }
        return heap;
    }

    public int[] percolateDown(int[] arr, int index){
        if(index > arr.length-1)
            return arr;

        if((index*2)+1 >= arr.length)
            return arr;
        else if((index*2)+2 >= arr.length){
            // compare parent with only left child
            if(arr[index] < arr[(index*2)+1]){
                arr = swap(arr, index, (index*2)+1);
            }
            return percolateDown(arr, (index*2)+1);
        }
        else{
            // compare parent with both children
            int largest = getMax(arr[index], arr[(index*2)+1], arr[(index*2)+2]);
            if(largest == arr[(index*2)+1]){
                arr = swap(arr, index, (index*2)+1);
                return percolateDown(arr, (index*2)+1);
            }
            else if(largest == arr[(index*2)+2]){
                arr = swap(arr, index, (index*2)+2);
                return percolateDown(arr, (index*2)+2);
            }
            else{
                // parent is the largest and the subtree is heapified
                return arr;
            }
        }
    }
    public int[] swap(int[] arr, int parent, int child){
        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
        return arr;
    }
    private int getMax(int a, int b, int c){
        if(a > b){
            if( a > c){return a;}
            else{return c;}
        }
        else {
            if( b > c){return b;}
            else{return c;}
        }
    }

    public List<Integer> getMaxHeap(){
        return maxHeap;
    }

}
