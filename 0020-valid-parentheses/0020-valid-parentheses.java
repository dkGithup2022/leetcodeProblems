import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '['||c=='{')
                open.add(c);
            
             if(open.isEmpty())
                return false;
            
            if( c == ')')
                if( open.peek() == '(')
                    open.pop();
                else
                    return false;
            
            if(c == ']')
                if( open.peek() == '[')
                    open.pop();
                else
                    return false;
                
            if(c=='}')
                if( open.peek() == '{')
                    open.pop();
                else
                    return false;
            
        }
        if(open.isEmpty())
            return true;
        return false; 
    }

}