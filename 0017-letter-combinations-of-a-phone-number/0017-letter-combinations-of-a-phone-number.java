class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return new ArrayList<>();

        Map<Integer, String> mapper = new HashMap<>();

        mapper.put(2, "abc");
        mapper.put(3, "def");
        mapper.put(4, "ghi");
        mapper.put(5, "jkl");
        mapper.put(6, "mno");
        mapper.put(7, "pqrs");
        mapper.put(8, "tuv");
        mapper.put(9, "wxyz");

        Deque<String> queue = new ArrayDeque<>();
        queue.offer("");

        for (char digit: digits.toCharArray()) {

            String letters = mapper.get(digit - '0');

            int size = queue.size();

            while (size > 0) {
                String comb = queue.poll();
                for (char letter: letters.toCharArray()) {
                    queue.offer(comb+letter);
                }
                size--;
            }
        }

        return new ArrayList<>(queue);

    }
}