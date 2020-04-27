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
}