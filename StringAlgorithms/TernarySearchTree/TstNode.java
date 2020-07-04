public class TstNode{
    char val;
    boolean isEndOfString;
    TstNode left;
    TstNode equal;
    TstNode right;
    boolean visited;

    public TstNode(char data){
        val = data;
        isEndOfString = false;
        left = null;
        equal = null;
        right = null;
        visited = false;
    }
    public TstNode(){
        isEndOfString = false;
        left = null;
        equal = null;
        right = null;
        visited = false;
    }
}
