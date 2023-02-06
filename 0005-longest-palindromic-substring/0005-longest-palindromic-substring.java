class Solution {
    public String longestPalindrome(String s) {
        int res = 0;
        String ms = "";
        if(s.length() <=1)
            return s;
        
        for(int i = 0; i< s.length(); i++){
            for(int j = i + 1; j<=s.length(); j++ ){
                if(j-i <= res)
                    continue;
                //System.out.println("i : " + i + ", j :" + j);
                //System.out.println("ss : " + s.substring(i,j));
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