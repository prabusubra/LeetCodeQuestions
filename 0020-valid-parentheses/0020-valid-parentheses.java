class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> bucket = new Stack<Character>();
        for (int i =0; i < s.length();i++){
            Character current = s.charAt(i);
            System.out.println(" current : "+current);
            if (bucket.isEmpty()) bucket.push(current);
            else if ('(' == bucket.peek() && ')' == current){
                bucket.pop();
            } else if ('{' == bucket.peek() && '}' == current){
                bucket.pop();
            } else if ('[' == bucket.peek() && ']' == current){
                bucket.pop();
            } else {
                bucket.push(current);
            }
        }

        return bucket.isEmpty();
        
        
    }
}