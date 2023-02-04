import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int n = s.length();
        
        if(n <= 1)
            return n;
        if(n==2)
            return s.charAt(0) == s.charAt(1) ? 1 : 2;
        
        HashSet<Character> set = new HashSet();
        int l = 0;
        int r = 0;
        set.add(s.charAt(r));
        
        while(l != n){
            if( r == n-1)
                l++;
            else if(rightMovable(set, s, r+1))
                set.add(s.charAt(++r));
            else{
                Character rm = s.charAt(l);
                if(set.contains(rm))
                    set.remove(rm);
                l++;
            }
            length = Math.max(length, r-l+1);
        }
        return length;
    }
    
    private boolean rightMovable( HashSet<Character> set, String s, int index){
        if(set.contains(s.charAt(index))){
            return false;
        }
        return true;
    }
}

/*

*/