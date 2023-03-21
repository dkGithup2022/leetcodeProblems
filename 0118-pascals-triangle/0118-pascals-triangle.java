class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        
        for(int i = 1 ;i <= numRows; i++ )
            res.add(newList(i));
        
        
        for(int i = 0; i<res.size() ; i++){
            List<Integer> list = res.get(i);
            for(int j = 0; j<list.size(); j++){
                if(j == 0 || j == list.size() -1  || i == 0)
                    continue;
                int left = res.get(i-1).get(j-1);
                int right = res.get(i-1).get(j);
                res.get(i).set(j, left + right); 
            }
        }
        
        return res;
    }
    
    private ArrayList<Integer> newList(int x){
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i< x; i++){
            if(i == 0 || i == x-1)
                list.add(1);
            else
                list.add(-1);
        }
        return list;
    } 
}