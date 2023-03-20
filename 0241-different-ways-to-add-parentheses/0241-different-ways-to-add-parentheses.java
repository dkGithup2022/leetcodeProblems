import java.util.*;
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> set = dq(expression);
        ArrayList<Integer> res = new ArrayList();
        for(int x : set)
            res.add(x);
        return res;
    }
    
    public ArrayList<Integer> dq(String expression){
        ArrayList<Integer> set = new ArrayList();
        /*
        숫자만 있는 경우 . 
        */
        if(expression.length() <= 2 
            && !expression.contains("+")
            && !expression.contains("-")
            && !expression.contains("*")
          ){
            int x = Integer.valueOf(expression);
            set.add(x);
            return set;
        }
        for( int i = 0; i<expression.length() ; i++){
            char c = expression.charAt(i);
            if (c == '+'){
                ArrayList<Integer> ls = dq(expression.substring(0,i));
                ArrayList<Integer> rs = dq(expression.substring(i+1, expression.length()));
                for(Integer ln : ls){
                    for(Integer rn : rs){
                        set.add( ln + rn);
                    }
                }
                
            }else if (c == '-'){
                ArrayList<Integer> ls = dq(expression.substring(0,i));
                ArrayList<Integer> rs = dq(expression.substring(i+1, expression.length()));
                for(Integer ln : ls){
                    for(Integer rn : rs){
                        set.add( ln - rn);
                    }
                }
            }else if (c == '*'){
                ArrayList<Integer> ls = dq(expression.substring(0,i));
                ArrayList<Integer> rs = dq(expression.substring(i+1, expression.length()));
                for(Integer ln : ls){
                    for(Integer rn : rs){
                        set.add( ln * rn);
                    }
                }
            }
        }
        
        return set;
    }
}