func minSubArrayLen(target int, nums []int) int {
    
    left, sum := 0, 0

    /**
    * uint(0) -> 00000000 00000000 00000000 00000000
    * ^uint(0) --> 11111111 11111111 11111111 11111111
    * ^unit(0) >> 1 --> 01111111 11111111 11111111 11111111
    **/

    minLenth := int(^uint(0) >> 1)

    for i:= 0; i < len(nums); i++ {
        sum += nums[i]

        for target <= sum {
            currLength := i - left +1
            if minLenth > currLength {
                minLenth = currLength
            }
            sum -= nums[left]
            left++
        }
    }

    if minLenth == math.MaxInt64 {
        return 0
    }
    return  minLenth;
}