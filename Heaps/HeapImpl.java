import java.util.ArrayList;
import java.util.List;

public class HeapImpl implements HeapADT{

        int[] heap;
        int heapType; // 1 is max heap, 0 is min heap
        int count; // points current index
        int capacity;

        // create Heap
        public HeapImpl(int capacity, int heapType){
            if(heapType!=0 && heapType!=1){
                System.out.println("Enter the heap type as 1 for max heap and 0 for min heap");
            }
            if(capacity<=0){
                System.out.println("Enter capacity value above 0 and with in 100");
                return;
            }
            this.heapType = heapType;
            this.capacity = capacity;
            heap = new int[capacity];
            count = -1;
        }

        // Get Parent
        public int getParent(int index){
            if((index-1)/2 < 0 )
                return -1;
            return (index-1)/2;
        }

        // Get Left Child
        public int getLeftChild(int index){
            if((index*2)+1 > count){
                return -1;
            }
            return (index*2)+1;
        }

        // Get Right Child
        public int getRightChild(int index){
            if((index*2)+2 > count){
                return -1;
            }
            return (index*2)+2;
        }

        // Insert into heap
        public void insert(int data){
            if(count == heap.length-1)
                resizeHeap();
            count++;
            // int i= count-1;
            // while(i >0 && ((data>heap[(i-1)/2] && heapType==1) || (data<heap[(i-1)/2] && heapType==0)) )  {
            //     System.out.println("inside while and value of i = "+ i);
            //     heap[i] = heap[(i-1)/2];
            //     i=(i-1)/2;
            // }
             heap[count] = data;
             percolateUp(count); //Alternate way
        }

        // Delete root from heap
        public int delete(){
            if(count<0)
                return -1;
            int max = heap[0];
            heap[0] = heap[count];
            count--;
            percolateDown(0);
            return max;
        }

        // Percolate up
        public void percolateUp(int index){
            int parent = getParent(index);
            if(parent == -1)
                return;
            if((heap[index]>heap[parent] && heapType==1) || (heap[index]<heap[parent] && heapType==0) ){

                int temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;
                percolateUp((index-1)/2);
            }
        }

        // Percolate down
        public void percolateDown(int index){
            int l, r, max, temp;
            l = getLeftChild(index);
            r = getRightChild(index);
            if(l!=-1 && heap[l] > heap[index])
                max = l;
            else
                max = index;
            if(r!=-1 && heap[r] > heap[max])
                max = r;
            if(max != index){
                temp = heap[index];
                heap[index] = heap[max];
                heap[max] = temp;
                percolateDown(max);
            }
        }

        public void resizeHeap(){
            capacity = capacity*2;
            int[] newHeap = new int[capacity];
            for(int i=0;i<heap.length;i++){
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }

        public void printHeap(){
            System.out.print("[");
            for(int i=0; i<count+1; i++){
                System.out.print(heap[i] + " ");
            }
            System.out.println("]");
        }

}
