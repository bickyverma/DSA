class Solution {
    public boolean uniformArray(int[] nums1) {

        int[] nums2 = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 != 0) {
                nums2[i] = nums1[i];
                continue;
            }
            boolean found = false;

            for (int j = 0; j < nums1.length; j++) {
                if (i != j && nums1[i] % 2 != nums1[j] % 2) {
                    nums2[i] = nums1[i] - nums1[j];
                    found = true;
                    break;
                }
            }

            if (!found) {
                return true;  //false;
            }
        }

        return true;
    }
}