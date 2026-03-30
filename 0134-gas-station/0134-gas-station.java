class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas = 0, currGas = 0, start = 0;
        
        for (int i=0; i< cost.length; i++ ) {
            int diff = gas[i] - cost[i];
            totalGas += diff;
            currGas += diff;

            if (currGas < 0) {
                currGas = 0;
                start = i +1;
            }
        
        }

        if (totalGas < 0) return -1;

        return start;

    }
}