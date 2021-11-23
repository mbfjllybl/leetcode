package Java.searchA2dMatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix[0].length * matrix.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (matrix[mid / matrix[0].length][mid % matrix[0].length] >= target) r = mid;
            else l = mid + 1;
        }
        if (matrix[l / matrix[0].length][l % matrix[0].length] == target) return true;
        return false;
    }
}
