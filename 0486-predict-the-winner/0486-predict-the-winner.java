class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int x = play(nums,0,nums.length-1, 1);
        System.out.println(x);
        return x>=0;
    }
    private int play(int[] nums, int s, int e, int turn){
        if( s == e){
            return nums[s]*turn;   
        }

        int left = nums[s]*turn + play(nums, s+1, e , turn * -1 );
        int right = nums[e]*turn + play(nums, s, e-1, turn * -1);
        
        return Math.max(left*turn, right*turn) * turn;
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