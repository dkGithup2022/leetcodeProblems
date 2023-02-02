class Solution {
    List<List<Integer>> result = new ArrayList();
    Set<String> duplicated = new HashSet();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<Integer> visited = new HashSet();
        btrk(nums,visited,new ArrayList<Integer>() );
        return result;
    }

    public void btrk(int[] nums, Set<Integer> visited, List<Integer> current ){
        if(nums.length == visited.size()){
            ArrayList<Integer> tmp = (ArrayList<Integer>) current.stream().map(i -> nums[i]).collect(Collectors.toList());
            String tmps = tmp.stream().map(i-> String.valueOf(i)).reduce((x,y) -> x+y).get();
            if( !duplicated.contains(tmps)){
                duplicated.add(tmps);
                result.add(tmp);
            }
            return;
        }

        for(int i = 0 ; i < nums.length ; i++ ){
            if( visited.contains(i) )
                continue;
            current.add(i);
            visited.add(i);
            btrk(nums, visited, current);
            current.remove( (int)current.size() - 1);
            visited.remove(i);
        }
    }
}