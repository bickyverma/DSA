class Info {
    private final int sum;
    private final int org;
    private final int idx;

    public Info(int sum, int org, int idx) {
        this.sum = sum;
        this.org = org;
        this.idx = idx;
    }

    public int getSum() { return this.sum; }
    public int getOrg() { return this.org; }
    public int getIdx() { return this.idx; }
}

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<Info> info = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int sum = findSum(nums[i]);
            info.add(new Info(sum, nums[i], i));
        }

        info.sort((a, b) -> {
            if (a.getSum() == b.getSum()) {
                return Integer.compare(a.getOrg(), b.getOrg());
            }
            return Integer.compare(a.getSum(), b.getSum());
        });

        // Original index -> destination index
        for (int i = 0; i < n; i++) {
            Info in = info.get(i);
            map.put(in.getIdx(), i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int curr = i;
            int cycleSize = 0;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = map.get(curr);
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }
        return swaps;
    }

    private int findSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}