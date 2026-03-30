class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int maxReach = startFuel;

        int index = 0, result =0;
        while (maxReach < target) {

            while (index < stations.length && maxReach >= stations[index][0]) {
                
                maxHeap.offer(stations[index][1]);
                index++;
            }

            if (maxHeap.isEmpty()) return -1;

            else {
                maxReach += maxHeap.peek(); //Re-fueling
                maxHeap.poll(); //remove used fuel
                result++;
            }
        }

        return result;

    }
}