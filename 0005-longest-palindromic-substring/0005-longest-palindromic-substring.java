class Solution {
    public String longestPalindrome(String s) {
        
        
        String result = "";
        int maxLen = 0;
        for (int i =0; i < s.length(); i++ ) {
            //odd length
            int start=i, end=i;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                
                if (end -start +1 > maxLen) {
                    result = s.substring(start, end+1);
                    maxLen = end - start +1;
                }

                start--;
                end++;
            }

            //even length
            start=i; end=i+1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                
                if (end - start+1 > maxLen) {
                    result = s.substring(start, end+1);
                    maxLen = end - start +1;
                }

                start--;
                end++;
            }

        }

        return result;

    }

}