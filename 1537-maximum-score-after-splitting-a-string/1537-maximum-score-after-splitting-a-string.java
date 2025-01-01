class Solution {
    public int maxScore(String s) {
        int zeroCounter = 0, oneCounter = 0, result = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                oneCounter++;
            }
        }

        for (int i = 0; i < s.length()-1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeroCounter += 1;
            } else {
                oneCounter -= 1;
            }
            result = Math.max(result, (zeroCounter + oneCounter));
        }
        return result;
    }
}