class Solution {
    public char findTheDifference(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int sum =0;
        while (i >=0 || j >=0){
            if (i >= 0)
                sum^=s.charAt(i--);
            if (j>=0)
                sum^=t.charAt(j--);
        }
        return (char)sum;
    }
}