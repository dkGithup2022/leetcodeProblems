class Solution {
    int m = -1;
    int n = -1;
    int mx = 0;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0 ; i< m ; i++){
            for( int j =0; j<n ; j++){
                if(i ==0 || j ==0){
                    dp[i][j] =  matrix[i][j] - '0';   
                }else{
                    if(matrix[i][j] == '0')
                        continue;
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diagonal = dp[i-1][j-1];
                    int min = Math.min(up,left);
                    min = Math.min(min, diagonal);
                    dp[i][j] = min+1;
                }
                 mx = Math.max(dp[i][j], mx);
            }
        }
        //for(int[] line : dp)
        //    System.out.println(Arrays.toString(line));
    
        return mx*mx;
    }
    
    
}