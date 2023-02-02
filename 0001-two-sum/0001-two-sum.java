import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap(); // num & cnt
        for(int i = 0; i < nums.length;  i++){
            int n = nums[i];
            ArrayList list = map.getOrDefault(n, new ArrayList());
            list.add(i);
            map.put(n, list);
        }
       
        
        for(int k : map.keySet()){
            if( map.containsKey(target- k)){
                if( target == 2*k ){
                    if( map.get(k).size() == 1){
                        continue;
                    }else{
                        return new int[]{ map.get(k).get(0), map.get(k).get(1)};
                    }
                }
                
                return new int[]{map.get(k).get(0), map.get(target-k).get(0)};
            }
        }        
        
        
        return null; 
        
    }
}

/*
 public int[] twoSum(int[] nums, int target) {
     
     HashMap<Integer, List<Integer> > map = new HashMap();
        
     for(int i =0 ; i< nums.length ; i++){
        int current = nums[i];

        if(map.containsKey(target - current))
            return new int[] {
                i, map.get(target-current).get(0)
                };
        
        List<Integer> list = map.getOrDefault(current , new ArrayList());
        list.add(i);
        map.put(current, list);
     }
        
     return null; 
    }
*/