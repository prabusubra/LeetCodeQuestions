class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0) return 0;

        Map<Character, Integer> slide = new HashMap<>();

        int left=0, result = 0;

        for (int i=0; i < s.length(); i++ ) {
            char ch = s.charAt(i);

            if (slide.containsKey(ch) && left <= slide.get(ch)) {
                left = slide.get(ch)+1;
            }
            slide.put(ch, i);
            result = Math.max(result, i-left+1);
        }

        return result;

    }
}