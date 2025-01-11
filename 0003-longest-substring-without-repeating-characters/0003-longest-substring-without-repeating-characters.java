class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> charToIndex = new HashMap<>();

        int left = 0, result = 0;

        for (int i = 0; i < s.length(); i++ ) {
            char curr = s.charAt(i);

            if (charToIndex.containsKey(curr) && charToIndex.get(curr) >= left) {

                left = charToIndex.get(curr) + 1;

            }

            charToIndex.put(curr, i);

            result = Math.max(result, i - left + 1);
        }

        return result;

    }
}