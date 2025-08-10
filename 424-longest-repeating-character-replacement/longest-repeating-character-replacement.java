class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, maxlen = 0, maxfreq = 0, r = 0;

        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(s.charAt(r)));
            while ((r - l + 1) - maxfreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                maxfreq = 0;
                for (Character c : map.keySet()) {
                    maxfreq = Math.max(maxfreq, map.get(c));
                }
                l++;
            }
            if(r-l+1-maxfreq<=k) maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }
}
