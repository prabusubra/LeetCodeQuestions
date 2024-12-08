class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;

        int[] maxSofar = new int[n];

        maxSofar[0] = events[0][2];

        for (int i=1; i < n; i++ ) {
            maxSofar[i] = Math.max(maxSofar[i-1], events[i][2]);
        }

        int maxSum = 0;

        for (int i=0; i < n; i++) {
            int[] curr = events[i];
            int currVal = curr[2];

            //binary search
            int left = 0; 
            int right = i - 1;
            int bestIndex = -1;

            while (left<=right) {
                
                int mid = left + (right - left)/2;

                if (events[mid][1] < curr[0]) {
                    bestIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            //calculate max

            if (bestIndex != -1) {
                maxSum = Math.max(maxSum, currVal + maxSofar[bestIndex]);
            } else {
                maxSum = Math.max(maxSum, currVal);
            }
        }

        return maxSum;

    }
}