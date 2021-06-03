public class TesterClass {
    public static void main(String[] args){
        System.out.println("Sorting Tester Class");
        int[] arr = {5, 8, 3, 6, 1, 7, 2, 4};
        System.out.println("Original Array");
        System.out.print("[ " + arr[0]);
        for(int i=1; i<arr.length; i++){
            System.out.print(", " + arr[i]);
        }
        System.out.println("]");

        SortingImpl sortArray = new SortingImpl();
        int[] sortedArr = sortArray.bubbleSort(arr);

        System.out.println("Bubbble Sort Array");
        System.out.print("[ " + sortedArr[0]);
        for(int i=1; i<sortedArr.length; i++){
            System.out.print(", " + sortedArr[i]);
        }
        System.out.println("]");

        int[] newArr = {55, 890,353, 60, 156, 729, -12, 004,1};
        System.out.println("Original Array");
        System.out.print("[ " + newArr[0]);
        for(int i=1; i<newArr.length; i++){
            System.out.print(", " + newArr[i]);
        }
        System.out.println("]");
        sortedArr = sortArray.selectionSort(newArr);


        System.out.println("Selection Sort Array");
        System.out.print("[ " + sortedArr[0]);
        for(int i=1; i<sortedArr.length; i++){
            System.out.print(", " + sortedArr[i]);
        }
        System.out.println("]");


        sortedArr = sortArray.insertionSort(newArr);


        System.out.println("Insertion Sort Array");
        System.out.print("[ " + sortedArr[0]);
        for(int i=1; i<sortedArr.length; i++){
            System.out.print(", " + sortedArr[i]);
        }
        System.out.println("]");


        sortedArr = sortArray.mergeSort(newArr);

        System.out.println("Merge Sort Array");
        System.out.print("[ " + sortedArr[0]);
        for(int i=1; i<sortedArr.length; i++){
            System.out.print(", " + sortedArr[i]);
        }
        System.out.println("]");

        int[] newArrQuick = {9,8,7,6,5,4,3,2,1,-8};
        System.out.println("Original Array");
        System.out.print("[ " + newArrQuick[0]);
        for(int i=1; i<newArrQuick.length; i++){
            System.out.print(", " + newArrQuick[i]);
        }
        System.out.println("]");
        sortedArr = sortArray.quickSort(newArrQuick);

        System.out.println("Quick Sort Array");
        System.out.print("[ " + sortedArr[0]);
        for(int i=1; i<sortedArr.length; i++){
            System.out.print(", " + sortedArr[i]);
        }
        System.out.println("]");
    }
}
