class Solution {
    public String longestPalindrome(String s) {
        int res = 0;
        String ms = "";
        
        if(s.length() <=1)
            return s;
        
        for(int i = 0; i< s.length(); i++){
            for(int j = i + Math.max(1,res); j<=s.length(); j++ ){
                if(j-i <= res)
                    continue;
                
                if(isP(s.substring(i,j))){
                    ms = s.substring(i,j);
                    res = j-i;
                }
            }
        }
        return ms;
    }
    
    private boolean isP(String x){
        if(x.length() <=1)
            return true;
        for(int i = 0, j = x.length() -1; i<=j; i++, j--){
            if(x.charAt(i) != x.charAt(j))
                return false;
        }
        return true;
        
    }
}