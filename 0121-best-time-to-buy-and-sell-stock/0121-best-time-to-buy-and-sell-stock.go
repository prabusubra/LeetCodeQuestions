func maxProfit(prices []int) int {
    
    var result int = 0
    
    minValue := prices[0]
    
    for i:=1; i < len(prices); i++ {
        
        if minValue > prices[i] {
            minValue = prices[i];
        } else {
            tmp := prices[i] - minValue
            if tmp > result {
                result = tmp
            }
        }
        
    }
    return result;
}