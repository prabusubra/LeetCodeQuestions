class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length, col = matrix[0].length;

        int left = 0, right = (row * col) - 1;


        while (left <= right) {

            int mid = left + (right-left)/2;

            int midVal = matrix[mid/col][mid%col];

            if (midVal == target) return true;
            else if (midVal < target) left = mid+1;
            else right = mid-1;

        }

        return false;

    }
}