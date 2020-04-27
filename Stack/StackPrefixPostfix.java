public class StackPrefixPostfix{
    
    /*
        infix operands and operator to be seperated by white space
        eg : A + ( B * C )
        
        Returns a prefix expression of given infix expression
    */
//    public String infixToPrefix(String infix){
//        String infix = new StringBuffer(infix).reverse().toString();
//        String[] infixArr = infix.split(" ");
//        StringBuffer prefix = new StringBuffer();
//        StackLinkedListImpl stack = new StackLinkedListImpl();
//        
//        for(String val : infixArr){
//            if(val.equals("(") || val.equals(")") ||val.equals("^") ||val.equals("/") ||val.equals("*") || val.equals("-") || val.equals("+")) {
//                
//                // push to stack if the stack is empty or stop top has lower priority
//                if((stack.isEmpty()) || (1 == getPrecedence( stack.top() < val))){
//                    stack.push(val);
//                }
//                else{
//                    while((! stack.isEmpty()) && ( -1 == getPrecedence(stack.top > val) )){
//                        String highPrtyOp = stack.pop();
//                        if(!highPrtyOp.equals("("))
//                            prefix.append(highPrtyOp);
//                    }
//                    if(!val.equals(")"));
//                        stack.push(val);
//                }
//            }
//            else {
//                prefix.append(val);
//            }
//        }
//        
//        while(! stack.isEmpty()){
//            prefix.append(stack.pop());
//        }
//        
//        return prefix.reverse().toString();
//    }
    
    
    /*
        infix operands and operator to be seperated by white space
        eg : A + ( B * C )
        
        Returns a postfix expression of given infix expression
    */
//    public String infixToPostfix(String infix){
//        
//        String[] infixArr = infix.split(" ");
//        StringBuffer postFix = new StringBuffer();
//        StackLinkedListImpl stack = new StackLinkedListImpl();
//        
//        for(String val : infixArr){
//            if(val.equals("(") || val.equals(")") ||val.equals("^") ||val.equals("/") ||val.equals("*") || val.equals("-") || val.equals("+")) {
//                
//                // push to stack if the stack is empty or stop top has lower priority
//                if((stack.isEmpty()) || (1 == getPrecedence( stack.top() < val))){
//                    stack.push(val);
//                }
//                else{
//                    while((! stack.isEmpty()) && ( -1 == getPrecedence(stack.top > val) )){
//                        String highPrtyOp = stack.pop();
//                        if(!highPrtyOp.equals("("))
//                            postFix.append(highPrtyOp);
//                    }
//                    if(!val.equals(")"));
//                        stack.push(val);
//                }
//            }
//            else {
//                postFix.append(val);
//            }
//        }
//        
//    }
    
    
    /*
        if operator 1 has higher precedence over operator 2 then return 1
        eg * > +
        if operator 2 has higher precedence over operator 1 then return -1
        eg - < /
        if both operator are same check for assiciativity and return either 1 or -1
        eg + -, - - 
    */
        
    public int getPrecedence(String operator1, String operator2){
        // checking if operator1 > operator2
        if(operator1.equals("+") && operator2.equals("-")){
            return -1;
        }
        return 1;
    }
    
    
    /*
        prefix evaluation
    */
    public int prefixEval(String prefix){
        String scanPrefix = new StringBuffer(prefix).reverse().toString();
        String[] prefixArr = scanPrefix.split(" ");
        StackLinkedListImpl stack = new StackLinkedListImpl();
        
        for(String val : prefixArr){
            
             if(val.equals("^") ||val.equals("/") ||val.equals("*") || val.equals("-") || val.equals("+")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                int res = -1;
                 
                 switch(val){
                    // case "^" : res = Math.pow(op1,op2);
                    //     break;
                     case "/" : res = op1 / op2 ;
                         break;
                     case "*" : res = op1 * op2 ;
                         break;
                     case "-" : res = op1 - op2 ;
                         break;
                     case "+" : res = op1 + op2 ;
                         break;
                 }
                 stack.push(res);
            }
            else {
                stack.push(Integer.parseInt(val));
            }
        }
        
        return(stack.pop());
    }
    
        
    /*
        postfix evaluation
    */
    public int postfixEval(String postfix){
        String[] postfixArr = postfix.split(" ");
        StackLinkedListImpl stack = new StackLinkedListImpl();
        
        for(String val : postfixArr){
            
             if(val.equals("^") ||val.equals("/") ||val.equals("*") || val.equals("-") || val.equals("+")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int res = -1;
                 
                 switch(val){
                    // case "^" : res = Math.pow(op1,op2);
                    //     break;
                     case "/" : res = op1 / op2 ;
                         break;
                     case "*" : res = op1 * op2 ;
                         break;
                     case "-" : res = op1 - op2 ;
                         break;
                     case "+" : res = op1 + op2 ;
                         break;
                 }
                 stack.push(res);
            }
            else {
                stack.push(Integer.parseInt(val));
            }
        }
        
        return(stack.pop());
    }
    
    
}