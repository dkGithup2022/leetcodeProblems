class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int[][] acm = new int[matrix.length][matrix[0].length];
        int rn = matrix.length;
        int cn = matrix[0].length;
        int maxArea = 0;
        for(int i = 0; i<  rn ; i++ ){
            for(int j =0; j< cn ;j++){
                if (i == 0 ){
                    acm[i][j] = matrix[i][j] - '0';
                }
                else{
                    if(matrix[i][j] - '0' == 0){
                        acm[i][j] = 0;
                    }else{
                        acm[i][j] = acm[i-1][j] + (matrix[i][j] - '0');
                    }
                }
            }
            maxArea = Math.max(maxArea, ma( acm[i]));
        }
       /* 
        for(int[] line : acm)
            System.out.println(Arrays.toString(line));
            */
        return maxArea;
    }
    
    private int ma(int[] line){
        int maxArea = 0;
        int n = line.length;
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i<= n ; i++){
            while((!stack.isEmpty()) && (i ==n || line[stack.peek()]>=line[i])){
                int height = line[stack.peek()];
                stack.pop();
                int width;
                if( stack.isEmpty())
                    width = i;
                else
                    width = i - stack.peek() -1;
                //System.out.println("i: " + i + ", width: " + width+ ", height :" + height + ", stack : " + stack);
                maxArea = Math.max(maxArea, width*height);  
            }
            stack.push(i);
        }
        //System.out.println("MAX AREA : " + maxArea);
        return maxArea;
    }
        
}