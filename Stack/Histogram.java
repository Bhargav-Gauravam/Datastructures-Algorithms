public class Histogram{
    
    /*
        Find the next greater element in the array for each index
    */
    public int[] nextGreater(int[] arr){
        if((null == arr) || (arr.length == 0)){
            return null;
        }
        int[] greater = new int[arr.length];
        StackLinkedListImpl stack = new StackLinkedListImpl();
        for(int i=0; i<arr.length; i++){
            while((!stack.isEmpty()) && (arr[stack.top()] < arr[i] )){
                greater[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(! stack.isEmpty())
              greater[stack.pop()] = -1;
        
        return greater;
    }
    
    /*
        Find the next smaller element in the array for each index
    */
    public int[] nextSmaller(int[] arr){
        if((null == arr) || (arr.length == 0)){
           return null; 
        }
        int[] smaller = new int[arr.length];
        StackLinkedListImpl stack = new StackLinkedListImpl();
        
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty() || (arr[stack.top()] <= arr[i] )){
                stack.push(i);
            }
            else{
                while( (!stack.isEmpty()) && arr[stack.top()] > arr[i]){
                    smaller[stack.pop()] = arr[i];
                }
                stack.push(i);
            }
        }
        while(! stack.isEmpty())
            smaller[stack.pop()] = -1;
        
        return smaller;
    }
                  
                  
}