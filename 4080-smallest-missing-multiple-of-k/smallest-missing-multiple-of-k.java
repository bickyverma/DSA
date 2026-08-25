class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);

        ArrayList<Integer> ar = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                if (ar.size() == 0 || ar.get(ar.size() - 1) != nums[i]) {
                    ar.add(nums[i]);
                }
            }
        }

        int multiple = k;

        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) == multiple) {
                multiple += k;
            } else {
                return multiple;
            }
        }

        return multiple;
    }
}