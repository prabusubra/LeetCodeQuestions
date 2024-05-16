class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <1) return false;
        n = n & n-1;
        return n==0? true:false;
    }
}