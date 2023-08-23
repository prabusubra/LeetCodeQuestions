class Solution {
    public int candy(int[] ratings) {
        int res = ratings.length;
        int[] result = new int[ratings.length];

        for (int i =1; i < result.length; i++){
            if (ratings[i-1] < ratings[i]) {
                result[i] = result[i-1] + 1;
            }
        }

        for (int i =result.length -2 ;i > -1 ; i--){
            if (ratings[i+1] < ratings[i] && result[i] <= result[i+1]) {
                result[i] = result[i+1] + 1;
            }
        }

        
        for (int i : result){
            res += i;
        }

        return res;
    }
}