class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) return result;

        Map<Integer, String> mapper = new HashMap<>();

        mapper.put(2, "abc");
        mapper.put(3, "def");
        mapper.put(4, "ghi");
        mapper.put(5, "jkl");
        mapper.put(6, "mno");
        mapper.put(7, "pqrs");
        mapper.put(8, "tuv");
        mapper.put(9, "wxyz");

        backtrack(digits, result, mapper, new StringBuilder(), 0);
        return result;

    }

    private void backtrack(String digits, List<String> result, 
                            Map<Integer, String> mapper, StringBuilder curr, int index) {

        
        if (index == digits.length()) {
            result.add(curr.toString());
            return;
        }
        //int currLtr = ;
        //System.out.println("Reee : "+currLtr);
        String letters = mapper.get(digits.charAt(index) - '0');

        for (int i = 0; i < letters.length(); i++ ) {
            curr.append(letters.charAt(i));

            backtrack(digits, result, mapper, curr, index+1);

            curr.deleteCharAt(curr.length()-1);
        }

    }
}