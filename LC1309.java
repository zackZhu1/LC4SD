class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 2 && s.charAt(i + 2) == '#') {
                res.append((char)('j' + (s.charAt(i) - '1') * 10 + s.charAt(i + 1) - '0'));
                i += 2;
            } else {
                res.append((char)('a' + (s.charAt(i) - '1')));
            }
        }
        return res.toString();
    }
}