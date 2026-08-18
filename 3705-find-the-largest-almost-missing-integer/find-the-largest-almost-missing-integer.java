class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if(k == n){
            int max = nums[0];
            for(int i : nums){
                max = Math.max(max, i);
            }
            return max;
        }

        List<Integer> arr = new ArrayList<>();
        if(k == 1){
            for(int i : nums){
                int cnt = 0;
                for(int j : nums){
                    if(i == j) cnt++;
                }
            if(cnt == 1) arr.add(i);
            }
        }else{
        int[] can = {nums[0], nums[n-1]};
        for(int i : can){
            int cnt = 0;
            for(int j : nums){
                if(i == j) cnt++;
            }
            if(cnt == 1) arr.add(i);
        }
    }
    
    if(arr.isEmpty()) return -1;
    return Collections.max(arr);
    }
}