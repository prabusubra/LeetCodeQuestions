class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        List<Integer> diff = new ArrayList<>();

        for (int i=0; i < s1.length(); i++ ) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }

        if (diff.size() > 2) return false;

        if (diff.size() == 2) {
            return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) &&
                s2.charAt(diff.get(0)) == s1.charAt(diff.get(1));
        } 

        return diff.size() == 0;
    }
}