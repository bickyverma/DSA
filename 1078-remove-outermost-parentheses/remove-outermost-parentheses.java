class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        String ans= "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(cnt > 0) ans += ch;
                cnt++;
            }
            
            else{
               cnt--;
                if(cnt > 0) ans += ch;
            }
        }
        return ans;
    }
}