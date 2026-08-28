class Solution {
    public String isPossible(int n, int[] freqIn, String cur, char mid, String target){
        int[] freq = freqIn.clone(); 

        for(int i=25; i>=0; i--){
            while(freq[i] > 0){
                cur += (char)('a'+i);
                freq[i]--;
            }
        }

        if(mid!='#'){
            
            String temp = cur;
            cur += mid;
            temp = new StringBuilder(temp).reverse().toString();
            cur += temp;
        }
        else {
            String temp = cur;
            temp = new StringBuilder(temp).reverse().toString();
            cur += temp;
        }

       
        return cur.compareTo(target) > 0 ? cur : "";
    }

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        if(n==1){
            if(s.compareTo(target) > 0) return s;
            else return "";
        }

        for(char c : s.toCharArray())
            freq[c-'a']++;

        char mid = '#';
        int oddCount = 0;

        for(int i=0; i<26; i++){
            if(freq[i]%2 != 0){
                mid = (char)('a'+i);
                freq[i]--;
                oddCount++;
            }

            freq[i] /= 2; 

            if(oddCount>=2) return ""; 
        }

        n /= 2; 

        String res = "", prefix = "";

        
        for(int i=0; i<n; i++){

            String cur = prefix;
            boolean isThereAny = false;

          
            for(int j=0; j<26; j++){

                if(freq[j] > 0){

                    freq[j]--;
                    cur += (char)('a'+j);

                    
                    String isPos = isPossible(n, freq, cur, mid, target);

                    if(!isPos.equals("")){
                        prefix = cur;     
                        isThereAny = true;

                        if(res.equals(""))
                            res = isPos;
                        else
                            res = res.compareTo(isPos) < 0 ? res : isPos; 

                        break;
                    }

                    freq[j]++;
                    cur = cur.substring(0, cur.length()-1);
                }
            }

            if(!isThereAny)
                return "";
        }

        return res; 
    }
}