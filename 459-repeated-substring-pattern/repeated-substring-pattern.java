class Solution {

    int[] helper(String s, int n) {
        int len = 0;
        int i = 1;
        int[] lps = new int[n];

        lps[0] = 0;
        while(i < n) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = helper(s, n);

        int ans = lps[n-1];

        if (ans > 0 && n % (n - ans) == 0) {
            return true;
        }
        return false;
    }
}