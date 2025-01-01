class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> scounter = new HashMap<>();

        Map<Character, Character> tcounter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if (scounter.containsKey(schar)) {
                if (scounter.get(schar) != tchar) {
                    return false;
                }
            } else {
                scounter.put(schar, tchar);
            }

            if (tcounter.containsKey(tchar)) {
                if (tcounter.get(tchar) != schar) {
                    return false;
                }
            } else {
                tcounter.put(tchar, schar);
            }
        }

        return true;

    }
}