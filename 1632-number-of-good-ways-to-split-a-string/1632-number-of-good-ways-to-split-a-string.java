class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();

        int result = 0;
        for (char ch : s.toCharArray()) 
            right.compute(ch, (k,val) -> val == null ? 1 : val+1);

        for (char ch: s.toCharArray()) {
            if (right.get(ch) > 1) right.compute(ch, (k, v) -> v -1);
            else right.remove(ch);

            left.compute(ch, (k,val) -> val == null ? 1 : val+1);

            if (left.size() == right.size()) result++;
        }

        return result;
    }
}