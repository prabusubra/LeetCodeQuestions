class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num: nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) +1);
            } else {
                freq.put(num, 1);
            }
        }
        
        int result = 0, max =0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (freq.get(entry.getKey()) > max){
                max = freq.get(entry.getKey());
                result = entry.getKey();
            }
        }

        return result;
    }
}