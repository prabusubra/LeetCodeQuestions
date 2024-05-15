class Solution {
    public String addBinary(String a, String b) {
        
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >=0 || j>=0){
            int sum = carry;
            //without sum-'0', it is giving 98 for 50 instead of zero and one.
            if (i >=0) sum += a.charAt(i--) - '0';
            if (j>=0) sum += b.charAt(j--) - '0';
            carry = sum >1 ? 1 :0;
            //System.out.println("Sum : "+sum+" carry : "+carry);
            sb.append(sum%2);
            
        }
        if (carry>0)sb.append(carry);
        return sb.reverse().toString();

    }
}