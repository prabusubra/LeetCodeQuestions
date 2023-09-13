class Solution {
    public int missingNumber(int[] nums) {
        
         
        
       int total = IntStream.range(1, nums.length+1).sum();
       int current = Arrays.stream(nums).sum();
        
        return total - current;
    }
}