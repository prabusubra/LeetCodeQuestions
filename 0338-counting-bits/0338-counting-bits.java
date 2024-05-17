class Solution {
    public int[] countBits(int n) {
        int[] result  = new int[n+1];
        for (int i=0;i<=n;i++){
            result[i] = getCountSetBits(i);
        }
        return result;
    }
    
    private int getCountSetBits(int n){
        int count = 0;
        while (n>0){
            n = n & n-1;
            count++;
        }
        return count;
    }
}