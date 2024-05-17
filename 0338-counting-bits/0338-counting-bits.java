class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
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
            if (cache.containsKey(n))
                n = cache.get(n);
            else{
                int temp = n;
                n = n & n-1;
                cache.put(temp, n);
            }
            
            count++;
        }
        return count;
    }
}