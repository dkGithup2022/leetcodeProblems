class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int x = play(nums,0,nums.length-1);
        return x>=0;
    }
    
    private int play(int[] nums, int s, int e){        
        return s==e ? nums[e] : Math.max(nums[e] -play(nums, s, e-1), nums[s] - play(nums, s+1, e));
    }
    
    /*
    게임 이론 아이디어 
    재귀함수 작성하기
        - 하위 분기가 없거나 의미가 없다면 return
        - 하위 분기에서 가장 높은 기댓값을 가지는 분기를 선택
        - 룰과 상황이 같다면 함수는 1개
        - 플레이어가 둘이라면 필요에 따라선 함수를 2개 
    
    */
}