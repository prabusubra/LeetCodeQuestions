class NumArray {

    int[] prefixSum ;

    public NumArray(int[] nums) {
        this.prefixSum = new int[nums.length + 1];
        int totalSum = 0;
        for (int i=0; i < nums.length; i++) {
            totalSum += nums[i];
            this.prefixSum[i] = totalSum;
        }
    }
    
    public int sumRange(int left, int right) {
        // -2, 0, 3, -5, 2, -1
        // -2, 0, 1, -4, -2, -3
        if (left > 0)
            return this.prefixSum[right] - this.prefixSum[left -1];
        else return this.prefixSum[right];

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */