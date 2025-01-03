class NumArray {

    int[] prefixSum ;

    public NumArray(int[] nums) {
        this.prefixSum = new int[nums.length + 1];
        for (int i=0; i < nums.length; i++) 
            this.prefixSum[i + 1] = this.prefixSum[i] + nums[i];
    }
    
    public int sumRange(int left, int right) {
        // -2, 0, 3, -5, 2, -1
        // -2, 0, 1, -4, -2, -3
        return this.prefixSum[right + 1] - this.prefixSum[left];

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */