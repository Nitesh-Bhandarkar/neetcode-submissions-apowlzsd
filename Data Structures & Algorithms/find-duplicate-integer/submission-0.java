class Solution {
    public int findDuplicate(int[] nums) {
        int slowPoint = 0;
        int fastPoint = 0;
        do{
            slowPoint = nums[slowPoint];
            fastPoint = nums[nums[fastPoint]];
        }
        while(slowPoint != fastPoint);

        slowPoint = 0;
        while(slowPoint != fastPoint){
            slowPoint = nums[slowPoint];
            fastPoint = nums[fastPoint];
        }

        return slowPoint;
    }
}
