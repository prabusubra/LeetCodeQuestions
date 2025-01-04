class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        // Determine first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            if (first[s.charAt(i) - 'a'] == -1) {
                first[s.charAt(i) - 'a'] = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }
        
        int count = 0;
        
        // Iterate over each character
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] != -1 && last[i] > first[i]) {
                // Use a set to count unique characters between first and last occurrence
                Set<Character> uniqueChars = new HashSet<>();
                for (int j = first[i] + 1; j < last[i]; j++) {
                    uniqueChars.add(s.charAt(j));
                }
                count += uniqueChars.size();
            }
        }
        
        return count;
    }
}