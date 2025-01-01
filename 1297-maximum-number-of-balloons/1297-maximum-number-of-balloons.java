class Solution {
    public int maxNumberOfBalloons(String text) {
        
        Map<Character, Integer> balloon = new HashMap<>();
        Map<Character, Integer> textCounter = new HashMap<>();

        for (char ch: text.toCharArray())
            textCounter.compute(ch, (k, v) -> v != null ? v +1 : 1);

        int b = textCounter.getOrDefault('b', 0);
        int a = textCounter.getOrDefault('a', 0);
        int l = textCounter.getOrDefault('l', 0)/2;
        int o = textCounter.getOrDefault('o', 0)/2;
        int n = textCounter.getOrDefault('n', 0);

        return Math.min(Math.min(b, a), Math.min(l, Math.min(o, n)));
    }
}