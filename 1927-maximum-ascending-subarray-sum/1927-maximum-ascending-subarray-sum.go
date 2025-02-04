func maxAscendingSum(nums []int) int {
    
    currSum := nums[0]

    maxSum := nums[0]
    
    for i:=1; i < len(nums); i++ {

        if nums[i-1] < nums[i] {
            currSum += nums[i]
        } else {
            currSum = nums[i]
        }

        if maxSum < currSum {
            maxSum = currSum
        }

    }


    return maxSum;
}