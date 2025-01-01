class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> grouping = new HashMap<>();

        for (String word: strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);

            grouping.compute(sortedWord, (key, value ) -> value == null ? new ArrayList<>() : value).add(word);
        }

        return new ArrayList(grouping.values());

    }
}