class Solution {
    public int divide(int dividend, int divisor) {
        Double q = (double)dividend / divisor;
        int qq = (int) (Math.floor(q));
        if( qq < 0 && qq  < q)
            return qq +1 ;
        
    
        return qq;
    }
}