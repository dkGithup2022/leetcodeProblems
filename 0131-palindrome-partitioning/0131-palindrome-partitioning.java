class Solution {
    List<List<String>> res = new ArrayList();
    
    public List<List<String>> partition(String s) {
        btrk(s,new ArrayList<String>(),0,0);
        return res;
    }
    
    private void btrk(String s, List<String> cur,  int former, int idx){
        
        if(idx == s.length()){
            if(!isPal(s.substring(former,idx)))
                return;
            
            cur.add(s.substring(former,idx));
             res.add(List.copyOf(cur));
            cur.remove(cur.size()-1);
            return;
        }

        if(isPal(s.substring(former,idx))){
            
            cur.add(s.substring(former,idx));
            btrk(s,cur,idx, idx+1);
            cur.remove(cur.size()-1);
            btrk(s,cur,former, idx+1);
        }else{
            btrk(s,cur,former, idx+1);
        }
        
        
    }
    
    private boolean isPal(String piece){
        
        if(piece == null || piece.length() == 0)
                return false;
        
        int right = piece.length()-1;
        int left = 0;
        
        while( left <= right){
            if(piece.charAt(left++) != piece.charAt(right--))
                return false;
        }
        
        return true;
        
    }
}