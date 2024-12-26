class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // Add all nums into the HashSet
        for (int num : nums) {
            set.add(num);
        }
        // Check from 1 to infinite for the first missing number
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}