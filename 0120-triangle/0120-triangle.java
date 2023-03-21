class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        
        for(int i = 0; i<triangle.size(); i++){
            if( i == 0 )
                continue;
            
            List<Integer> line = triangle.get(i);
            for(int j = 0; j<line.size() ; j++){
                if(j == 0){
                    line.set(j,line.get(j) + triangle.get(i-1).get(j));
                }else if (j == line.size()-1){
                    line.set(j, line.get(j) + triangle.get(i-1).get(j-1));
                }else{
                    int x1 = line.get(j) + triangle.get(i-1).get(j-1);
                    int x2 = line.get(j) + triangle.get(i-1).get(j);
                    line.set(j, Math.min(x1, x2));
                }
            }
        }
      
        return Collections.min(triangle.get(triangle.size()-1));
    }
}