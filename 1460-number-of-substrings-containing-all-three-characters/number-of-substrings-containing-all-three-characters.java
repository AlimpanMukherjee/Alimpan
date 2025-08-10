// class Solution {
//     private long func(String s) {
//         long l = 0, r = 0;
//         long count = 0;
//         HashMap<Character, Integer> map = new HashMap<>();

//         while (r < s.length()) {
//             map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
//             while (map.size() > 2) {
//                 map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
//                 if (map.get(s.charAt(l)) == 0) {
//                     map.remove(s.charAt(l));
//                 }
//                 l++;
//             }
//             count += (long) (r - l + 1);
//             r++;
//         }

//         // return count;
//     }
//     public int numberOfSubstrings(String s) {
//         long n = s.length();
//         long totalSubstrings = n * (n + 1) / 2; 
//         return totalSubstrings - func(s);    
//     }
// }

import java.util.HashMap;

class Solution {
    private long func(String s) {
        long l = 0, r = 0;
        long count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            map.put(s.charAt((int) r), map.getOrDefault(s.charAt((int) r), 0) + 1);
            while (map.size() > 2) {
                map.put(s.charAt((int) l), map.get(s.charAt((int) l)) - 1);
                if (map.get(s.charAt((int) l)) == 0) {
                    map.remove(s.charAt((int) l));
                }
                l++;
            }
            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public int numberOfSubstrings(String s) {
        long n = s.length();
        long totalSubstrings = n * (n + 1) / 2;
        return (int) (totalSubstrings - func(s)); // cast to int
    }
}
