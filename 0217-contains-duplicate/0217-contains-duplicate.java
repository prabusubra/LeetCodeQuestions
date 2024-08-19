class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int a: nums){
            if (!set.add(a)) return true;
        }
        return false;
    }
}