class Solution {
    public int maxPower(String s) {
     
        int max=0, count=0;
        
        for (int i=1; i< s.length();i++){
            if (s.charAt(i-1) == s.charAt(i)){
                count++;
            } else {
                count = 0;
            }
            max = Math.max(count, max);
        }
        return max+1;
    }
}