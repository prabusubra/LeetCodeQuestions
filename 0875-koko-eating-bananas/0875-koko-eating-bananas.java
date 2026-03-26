class Solution {
     public int minEatingSpeed(int[] piles, int h) {

        int max = Arrays.stream(piles).max().orElse(0);
        
        int left = 1, right = max, result=0;
        
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (canEat(piles, h, mid)) {
                result = mid;
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        
        return result;

    }
    
    private boolean canEat(int[] piles, int h, int m) {
        int time = 0;
        
        for (int pile: piles) {
            time += Math.ceil((double)pile/m);
        }
        
        return time <= h;
        
    }
}