class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] nums2 = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] % 2 == 0){
                nums2[i] = nums1[i];
            }
            return true;
        }
        
        for(int i = 0; i < nums1.length; i++){
            int j = i+1;
            if(j < nums1.length){
                nums2[i] = nums1[i] - nums1[j];
            }
        } 
        return false;  
    }
}