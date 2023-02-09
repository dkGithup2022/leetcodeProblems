class Solution {
    
     public int maxArea(int[] height) {
    
        int max = 0;
        int left = 0;
        int right = height.length-1;

        while(left< right){
            int area = (right-left) * Math.min(height[left],height[right]);
            max = Math.max(max,area);

            if( height[left] > height[right]){
                right--; 
            }else{
                left++;
            }
        }
        /*
        index :     0 1 2 3 4 5 6 7 8 
        value :     1 8 6 2 5 4 9 3 7
                    l               r
        area : min(1,7) * (8-0) =8

        lv< rv : i++
        index :     0 1 2 3 4 5 6 7 8 
        value :     1 8 6 2 5 4 9 3 7
                      l             r
        area : min(8,7) * (8-1) =49

        lv>rv : rc--
        index :     0 1 2 3 4 5 6 7 8 
        value :     1 8 6 2 5 4 9 3 7
                      l           r  
        area : min(8,3) * (8-2) =18

        index :     0 1 2 3 4 5 6 7 8 
        value :     1 8 6 2 5 4 9 3 7
                      l         r    
        area : min(8,9) * (8-e) =2
        */
        return max;
    }
}