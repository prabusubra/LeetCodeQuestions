class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> grouping = new HashMap<>();

        for (String word: strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);

            grouping.computeIfAbsent(sortedWord, key -> new ArrayList<>()).add(word);
        }

        return new ArrayList(grouping.values());

    }
}