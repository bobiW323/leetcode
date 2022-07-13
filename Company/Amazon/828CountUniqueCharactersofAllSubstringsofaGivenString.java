class Solution {
    public int uniqueLetterString(String s) {
        int res = 0;
        int[][] alphabet = new int[26][2];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = new int[]{-1 ,-1};
        }
        
        for (int i = 0; i < s.length(); i++) {
            int[] index = alphabet[s.charAt(i) - 'A'];
            // count the number of substrings that contains certain unique alphabet
            res += (index[1] - index[0]) * (i - index[1]);
            index[0] = index[1];
            index[1] = i;
        }
        
        for (int[] ind : alphabet) {
            res += (ind[1]  -ind[0]) * (s.length() - ind[1]);
        }
        return res;
    }
}
