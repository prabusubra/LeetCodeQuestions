func minSubArrayLen(target int, nums []int) int {
    
    left, sum, min := 0, 0, math.MaxInt64

    for i:= 0; i < len(nums); i++ {
        sum += nums[i]

        for target <= sum {
            minLength := i - left +1
            if min > minLength {
                min = minLength
            }
            sum -= nums[left]
            left++
        }
    }

    if min == math.MaxInt64 {
        return 0
    }
    return  min;
}