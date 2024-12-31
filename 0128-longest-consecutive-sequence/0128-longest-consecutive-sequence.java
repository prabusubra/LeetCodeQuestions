class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> unique = new HashSet<>();

        for (int num: nums) unique.add(num);

        int longestStreak = 0;
        for (int num: nums) {
            if (!unique.contains(num-1)) {
                int currStreak = 0, curr = num;
                while (unique.contains(curr)) {
                    curr++;
                    currStreak++;
                }

                longestStreak = Math.max(longestStreak, currStreak);
            }
        }

        return longestStreak;

    }
}