class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] delta = new int[n + 1]; // Create a difference array of size n+1
        
        // Process all shifts using the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            delta[start] += (direction == 1) ? 1 : -1;
            delta[end + 1] -= (direction == 1) ? 1 : -1;
        }
        
        // Compute prefix sum to get net shifts for each character
        int[] shiftsArray = new int[n];
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += delta[i];
            shiftsArray[i] = currentShift;
        }
        
        // Apply shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char originalChar = s.charAt(i);
            int shiftedValue = (originalChar - 'a' + shiftsArray[i]) % 26;
            if (shiftedValue < 0) shiftedValue += 26; // Handle negative shifts
            result.append((char) ('a' + shiftedValue));
        }
        
        return result.toString();
    }
}