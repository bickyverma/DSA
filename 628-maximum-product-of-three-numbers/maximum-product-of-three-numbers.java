class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                
                int ans1 = nums[0] * nums[1] * nums[n-1];
                int ans2 = nums[n-1] * nums[n-2] * nums[n-3];

                if(ans1 > ans2){
                    return ans1;
                }else{
                    return ans2;
                }

            }else{
                return nums[n-1] * nums[n-2] * nums[n-3];
            }
        }

        return -1;
    }
}