import java.util.*;

class Solution {
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
}

/*
 public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        // ㄴ> nlog n 
        for(int i =0; i< nums.length ; i++){
            //ㄴ> n
            int tmp = target - nums[i];
            int index = binarySearch(nums, i+1, nums.length-1);
            if(index == -1)
                continue;
            else
                
            //ㄴ> logn
        }
    }
    
    public int binarySearch(int[] arr, int lo, int hi, int target){
        
        
        while(lo>hi){
            int mid = (lo+hi)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target){
                hi = mid -1;
            }else{
                lo = mid +1;
            }
        }
        return -1;
    }
    
    
    public int[] twoSum_(int[] nums, int target) {
       
        HashMap<Integer,Integer> map = new HashMap(); // value, index
        for(int i = 0 ; i< nums.length; i++){
            int tmp = target - nums[i];
            if( map.keySet().contains(tmp))
                return new int[]{map.get(tmp), i};
            else{
                map.put(nums[i], i);
            }
        }
        return null;
    }

      HashMap<Integer, Integer> map = new HashMap();
        // { value = [index1, index2]}

        for(int i = 0; i< nums.length ; i++){
            int tmp = target - nums[i];
           if( map.keySet().contains(tmp))
                return new int[]{map.get(tmp), i};
            else{
                map.put(nums[i], i);
            }
        }

        return null;


*/