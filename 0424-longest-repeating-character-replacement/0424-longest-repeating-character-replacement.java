class Solution {
    public int characterReplacement(String s, int k) {
        
        int left = 0, maxLength = 0, maxFreq = 0;
        int[] counter = new int[26];

        for (int i=0; i < s.length(); i++ ) {
            counter[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq, counter[s.charAt(i) - 'A']);


            int currLength = i - left + 1;
            int windowSize = currLength - maxFreq;
            if ( windowSize > k) {
                counter[s.charAt(left) - 'A']--;
                left++;
            }
            currLength = i - left + 1;

            maxLength = Math.max(maxLength, currLength);

        }

        return maxLength;
    }
}