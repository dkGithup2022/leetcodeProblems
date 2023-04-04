class Solution {
   
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        boolean[][] dp = new boolean[s1.length()+1][ s2.length() +1];
        for(int i = 0; i<=s1.length(); i++){
            for(int j =0 ; j<= s2.length(); j++){
                if( i==0 && j==0){
                    dp[i][j]=true;
                    continue;
                }
                
                if(i == 0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j-1);
                    continue;
                }
                if(j ==0 ){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                    continue;
                }
                
               dp[i][j] = 
                   (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
                ||
                   (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                
            }
        }
        
        return dp[s1.length()][s2.length()];
            
        
    }
}

/* TIME EXCEEDED  -> brute force with backtracking 
class Solution {
    String x = "";
    String s1;
    String s2;
    String s3;
    boolean flag = false;
    public boolean isInterleave(String s_1, String s_2, String s_3) {
        s1 = s_1;
        s2 = s_2;
        s3 = s_3;

        if (s3.length() == 0)
            return true;
        
        if(s1.length() + s2.length() != s3.length())
            return false;

        btrk(0,0,0);
        return flag;
    }
    
    public void btrk(int i1, int i2, int i3){
        if (flag)
            return;
        
        if(i3 == s3.length()){
            if(i1 == s1.length() && i2 == s2.length())
                flag = true;
            return;
        }
        
        char curChar = s3.charAt(i3);
        
        if( 
            (i1 < s1.length() && s1.charAt(i1) == curChar) 
            && 
            ( i2< s2.length() && s2.charAt(i2) == curChar)
        ){
            btrk(i1+1, i2, i3+1);
            btrk(i1,i2+1, i3+1);
            
        }
        else if(i1 < s1.length() && s1.charAt(i1) == curChar){
            btrk(i1+1, i2, i3+1);
        }else if (i2< s2.length() && s2.charAt(i2) == curChar){
            btrk(i1, i2+1, i3+1);
        }else{
            return;
        }
        
    }
}
*/