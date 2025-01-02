class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('(', ')');
        mapping.put('[', ']');
        mapping.put('{', '}');
        

        for (int i=0; i < s.length(); i++ ) {
            char ch = s.charAt(i);
            
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (mapping.get(top) != ch)
                    return false;
            }

        }
        return stack.isEmpty();
    }
}