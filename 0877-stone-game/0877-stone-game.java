class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
    // 앨리스 최적의 플레이
    public int playAlice(int[] piles , int s , int e){
        if(s == e)
            return piles[s];
        return Math.max(piles[s] -  playBob(piles, s+1, e), piles[e] - playBob(piles,s, e-1) );
        
    }
    
    // 밥 최적의 플레이 
    public int playBob(int[] piles, int s, int e){
         if(s == e)
            return piles[s];
        return Math.max(piles[s] -  playAlice(piles, s+1, e), piles[e] - playAlice(piles,s, e-1) );
    }
}