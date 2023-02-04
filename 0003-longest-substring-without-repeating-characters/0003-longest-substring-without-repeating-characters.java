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
            if( r == n-1){
                l++;
            }
            else if(rightMovable(set, s, r+1)){
                r++;
                set.add(s.charAt(r));
            }else{
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
public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;
        int left = 0;
        int right = 0;
        HashSet<Character>  set = new HashSet();
        set.add(s.charAt(0));
        int max = 1;
        while(right != s.length()){
            // case 0 : 끝까지 간 경우
            System.out.println("set: " + set);
            if(right==s.length() -1){
                max = Math.max(max,set.size());
                break;
            }
            // case 1 : 오른 확장이 가능한 경우.
            else if( !set.contains( s.charAt(right+1)) ){
                right++;
                set.add( s.charAt(right));
                max = Math.max(max,set.size());
            }
            // case 2 : 오른 확장이 불가능 한 경우.  
            else if( set.contains( s.charAt(right+1)) ){
                set.remove( s.charAt(left));
                left++;
            }  
        }
        return max;
    }
*/
