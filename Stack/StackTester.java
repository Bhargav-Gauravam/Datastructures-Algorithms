public class StackTester{
    
    public static void main(String[] args){
        System.out.println("Stack Tester main method");
        
   
/*      // Prefix and Postfix evaluation
        StackPrefixPostfix eval = new StackPrefixPostfix();
        String val = "- + 8 / 6 3 2";
        String postVal = "5 3 + 6 2 / * 3 5 * +";
        System.out.println("Prefix evaluation result of "+ val +" is "+ eval.prefixEval(val));
        System.out.println("Post evaluation result of "+ postVal +" is "+ eval.postfixEval(postVal));
        */
        
        // next greater
        Histogram histogram = new Histogram();
        int[] arr = {3,1,2,6,-2,-3,4,3};
        arr = histogram.nextGreater(arr);
        System.out.print("next greater array = [ " + arr[0]);
        for(int i=1;i<arr.length;i++){
            System.out.print(" , " +arr[i]);
        }
        System.out.println("]");
        
        // next smaller
        int[] arrs = {3,1,2,6,-2,-3,4,3};
        arr = histogram.nextSmaller(arrs); 
        System.out.print("next smaller array = [ " + arr[0]);
        for(int i=1;i<arr.length;i++){
            System.out.print(" , " +arr[i]);
        }
        System.out.print("]");
    }
    
    
}