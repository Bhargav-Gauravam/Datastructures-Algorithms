public class SortingImpl implements SortingADT{

    public int[] bubbleSort(int[] arr){
        if( (null == arr) || (arr.length == 1) )
            return arr;
        boolean sorted = false;
        for(int i = 0; (i < arr.length - 1) && (!sorted) ; i++){
            sorted = true;
            for(int j=0 ; j<arr.length -(i+1); j++){
                if(arr[j+1] <= arr[j] ){
                    sorted = false;
                    //swap
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr){
        int[] sortedArr = arr;
        for(int i=0; i<sortedArr.length-1;i++){
            for(int j=i+1; j<sortedArr.length; j++){
                if(sortedArr[j] < sortedArr[i]){
                    int temp = sortedArr[i];
                    sortedArr[i] = sortedArr[j];
                    sortedArr[j] = temp;
                }
            }
        }
        return sortedArr;
    }

    public int[] insertionSort(int[] arr){
        int[] sortArr = arr;
        for(int i=1; i<sortArr.length; i++){
            for(int j=0; j<i;j++){
                if(sortArr[i]<sortArr[j]){
                    sortArr = insert(sortArr, i, j);
                }
            }
        }
        return sortArr;
    }

    public int[] insert(int[] arr, int i, int j){
        int[] newArr = arr;
        int temp = newArr[i];
        for(int k=i; k>j; k--){
            newArr[k] = newArr[k-1];
        }
        newArr[j] = temp;
        return newArr;
    }

    public int[] mergeSort(int[] arr){
        if(null == arr || arr.length==0)
            return null;
        int[] temp = new int[arr.length];
        selection(arr, 0, arr.length-1, temp);
        return arr;
    }

    public void selection(int[] arr, int low, int high, int[] temp){
        if(low<high){
            int mid = (low+high-1)/2;
            selection(arr, low, mid, temp);
            selection(arr, mid+1, high, temp);
            merge(arr, low, mid, high, temp);
        }
    }

    public void merge(int[] arr, int low, int mid, int high, int[] temp){
        int x = low;
        int y = mid+1;
        for(int i=low; i<=high; i++){
            if(x>mid){
                temp[i] = arr[y];
                y++;
                continue;
            }
            if(y>high){
                temp[i] = arr[x];
                x++;
                continue;
            }

            if((y<=high && x>mid) || arr[x] > arr[y]){
                temp[i] = arr[y];
                y++;
            }
            else {
                if((y>high && x<=mid) || arr[x] <= arr[y]){
                    temp[i] = arr[x];
                    x++;
                }
            }
        }

        // move temp values to arr within the range low - high
        for(int i=low; i<=high; i++){
            arr[i] = temp[i];
        }
    }


    public int[] quickSort(int[] arr){

        if(null == arr || arr.length == 0)
            return arr;

        sort(arr, 0, arr.length-1);
        return arr;
    }
    public void sort(int[] arr, int low, int high){
        if(low >=high || arr.length <= 1)
            return;

        int partIdx = partition(arr, low, high);
        sort(arr, low, partIdx-1);
        sort(arr, partIdx+1, high);

    }
    public int partition(int[] arr, int low, int high){
        int pivot = low;
        int count = 0;

        // Finding the number of elements lesser than the pivot
        for(int i=low; i<high; i++){
            if(arr[i+1] < arr[pivot]){
                count++;
            }
        }
        // cluster the values lesser than pivot to first half
        // of array and larger elements to second half of array.
        int s=low+1;
        int e=high;
        while(s<e){
            if(arr[s] < arr[pivot]){
                s++;
            }
            if(arr[e] > arr[pivot]){
                e--;
            }
            if((s<e) && (arr[s]>arr[pivot]) && (arr[e]<arr[pivot])){
                int temp = arr[e];
                arr[e] = arr[s];
                arr[s] = temp;
                s++;
                e--;
            }
        }

        if(count>0){
            int temp = arr[pivot];
            arr[pivot] = arr[pivot+count];
            arr[pivot+count] = temp;
        }
        return pivot+count;
    }

}
