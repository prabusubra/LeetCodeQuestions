class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> mapper = new HashMap<>();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int num: nums2) {

            while (!stack.isEmpty() && stack.peek() < num) 
                mapper.put(stack.pop(), num);

            stack.push(num);

        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = mapper.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}