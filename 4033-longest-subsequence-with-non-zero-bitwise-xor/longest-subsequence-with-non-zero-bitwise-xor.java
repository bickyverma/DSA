class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int nonZero = 0;
        int xor = 0;

        for(int x : nums){
            xor = xor ^ x;
            if(x != 0) nonZero++;
        }

        if(xor != 0) return n;
        if(nonZero == 0) return 0;
        return n - 1;
    }
}