class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        java.util.Arrays.sort(indices, (a, b) -> {
            int sumA = digitSum(nums[a]);
            int sumB = digitSum(nums[b]);
            if (sumA != sumB) {
                return sumA - sumB;
            }
            return nums[a] - nums[b];
        });
        
        int[] targetPos = new int[n];
        for (int newPos = 0; newPos < n; newPos++) {
            int originalIndex = indices[newPos];
            targetPos[originalIndex] = newPos;
        }
        boolean[] visited = new boolean[n];
        int cycles = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycles++;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = targetPos[j];
                }
            }
        }
        
        return n - cycles;
    }
    
    private int digitSum(int num) {
        int sum = 0;
        num = Math.abs(num);
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}