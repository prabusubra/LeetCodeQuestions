class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     
        int gasRemaining = 0;
        int startindex = 0;
        int total = 0;
        for (int i =0; i < gas.length; i++){
            total += gas[i] - cost[i];
            gasRemaining += gas[i] - cost[i];
            
            if (gasRemaining < 0){
                 startindex = i+1;
                gasRemaining = 0;
            }
            
        }
        
        return total < 0 ? -1: startindex;
    }
}