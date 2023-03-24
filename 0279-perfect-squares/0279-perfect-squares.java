class Solution {
  
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = Integer.MAX_VALUE;
        ArrayList<Integer> sqs= new ArrayList();
        HashSet<Integer> set = new HashSet();
        int x = 1;
        while( x*x<= n){
            sqs.add(x*x);
            set.add(x*x);
            x++;
        }
        for(int i=1 ;i<=n ; i++ ){
            if( set.contains(i)){
                dp[i] = 1;
                continue;
            }
            int curMin = Integer.MAX_VALUE;
            for(int j = 0 ; j < sqs.size() && sqs.get(j) < i; j++){
                int former = dp[i-sqs.get(j)];
                curMin = Math.min(curMin, former);
            }
            dp[i] = curMin+1;
        }
        //System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}