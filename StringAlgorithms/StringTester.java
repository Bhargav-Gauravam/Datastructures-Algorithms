public class StringTester{

    public static void main(String[] args){

        // Check if substring is present in a string
        String str = "qwersafoosbalasdfoiuqfoosballfofwerfo";
        String subStr = "foosball";

        // check if substring exists in main String
        char[] strChar = str.toCharArray();
        char[] subStrChar = subStr.toCharArray();

        for(int i=0; i<=(strChar.length-subStrChar.length); ++i){
            boolean matchFound = true;
            System.out.print(" "+i+" ");
            for(int j=0; j<subStrChar.length; j++){
                if(strChar[i+j] != subStrChar[j]){
                    matchFound = false;
                    i = i+j;
                    break;
                }
            }
            if(matchFound){
              System.out.println("");
              System.out.println("Sub String Found in the main String");
            }
        }
        System.out.println("");
    }

}
