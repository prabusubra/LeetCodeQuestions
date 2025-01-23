class Solution {
    public int jump(int[] nums) {
        
        if (nums.length <= 1) return 0;

        int noOfJumps = 0, currJump = 0, maxJump = 0; //2

        //2,3,1,1,4
        for (int i=0; i < nums.length; i++ ) { //
            
            maxJump = Math.max(maxJump, i + nums[i]);

            if (currJump  == i) {

                noOfJumps++;
                currJump = maxJump;

                if (currJump >= nums.length-1) break;
            }

            

        }
        return noOfJumps;
    }
}