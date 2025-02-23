class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2]; 

        int left = 0, right = numbers.length-1;

        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp < target) {
                left++;
            } else if (tmp > target) {
                right--;
            } else {
                //index is zero based, so adding 1 for both
                result[0] = left +1;
                result[1] = right +1;
                break;
            }
        }

        return result;
    }
}