func lengthOfLIS(nums []int) int {
    
    dp := make([]int, len(nums))

    result := 1

    for i:= range nums {
        dp[i] = 1
    }

    for curr:=1; curr < len(nums); curr++ {
        for prev:=0; prev < curr; prev++ {
            if nums[prev] < nums[curr] {
                if dp[curr] < dp[prev] +1 {
                    dp[curr] = dp[prev] +1
                }
            }
        }
        if result < dp[curr] {
            result = dp[curr]
        }
    }

    return result

}