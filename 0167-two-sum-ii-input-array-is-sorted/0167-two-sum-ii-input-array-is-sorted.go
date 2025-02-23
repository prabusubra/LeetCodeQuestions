func twoSum(numbers []int, target int) []int {
    
    left := 0
    right := len(numbers)-1

    for left < right {

        tmp := numbers[left] + numbers[right]

        if tmp < target {
            left++
        } else if tmp > target {
            right--
        } else {
            return []int{left+1, right+1}
        }
    }

    return nil
}