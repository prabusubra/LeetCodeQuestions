class Solution {
    public int characterReplacement(String s, int k) {
        
        int left = 0, maxLength = 0, maxFreq = 0;
        int[] counter = new int[26];

        for (int i=0; i < s.length(); i++ ) {
            
            maxFreq = Math.max(maxFreq, ++counter[s.charAt(i) - 'A']);

            if ( (i - left + 1) - maxFreq  > k) {
                counter[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, i - left + 1);

        }

        return maxLength;
    }
}