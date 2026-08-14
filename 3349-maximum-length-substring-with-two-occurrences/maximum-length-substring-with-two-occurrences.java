class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        //Using Sliding Window
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, res = 0;
        for(int j = 0; j < n; j++){
            //char ch = s.charAt(j);
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while(map.get(s.charAt(j)) > 2){
                char l = s.charAt(i);
                map.put(l, map.get(l)-1);
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}