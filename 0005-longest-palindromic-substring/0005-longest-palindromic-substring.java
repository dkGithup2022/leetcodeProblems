class Solution { 
    public String longestPalindrome(String s) {
        int res = 0; 
        String ms = "";
        
        if(s.length() <=1)
            return s;
        
        // bab"aababbb
        // bab: palindrom 
        // aa -> x
        // 
        
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

/*    public String longestPalindrome(String s) {
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
    */

/*

 public String longestPalindrome(String s) {
        int n = s.length();
        int res = 0;
        String ms = "";
        
        if(s.length() <=1)
            return s;
        
        for(int i = 0; i<n ;i++){
            int l = i, r= i;
            while(l >= 0 && r < n){
                
                System.out.println("1 : l : " + l + " , r: " + r);
                if(s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }else
                    break;
            }
            System.out.println("2: l : " + l + " , r: " + r);
            res= Math.max(res,r-l);
            
            if(i+1<n){
                l = i; r= i+1;
                while(l >= 0 && r < n){
                    
                    System.out.println("3: l : " + l + " , r: " + r);
                    if(s.charAt(l) == s.charAt(r)){
                        l--;
                        r++;
                    }else
                        break;
                }
            }
        }
        
        return ms;
    }*/