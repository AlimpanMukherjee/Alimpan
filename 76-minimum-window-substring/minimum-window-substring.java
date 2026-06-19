// class Solution {
//     public String minWindow(String s, String t) {
//         String ans="";
//         int l=0;
//         int r=0;
//         Map<Character,Integer> map=new HashMap<>();
//         Map<Character,Integer> req=new HashMap<>();
//         int count=0;
//         for(int i=0;i<t.length();i++)
//         {
//             if(req.containsKey(t.charAt(i)))req.put(t.charAt(i),req.get(t.charAt(i))+1);
//             else req.put(t.charAt(i),1);
//         }
//         int minlen=Integer.MAX_VALUE;
//         while(r<s.length())
//         {
//             if(req.containsKey(s.charAt(r)))
//             {
//                 if(map.containsKey(s.charAt(r)))
//                 {
//                     map.put(s.charAt(r),map.get(s.charAt(r))+1);
//                 }
//                 else map.put(s.charAt(r),1);
//                 if(req.get(s.charAt(r))==map.get(s.charAt(r)))count++;


//                 while(count==req.size())
//                 {
//                     //while(count==req.size())
//                     if(r-l+1<minlen)
//                     {
//                         minlen=r-l+1;
//                         ans=s.substring(l,r+1);
                        
//                     }
            
//                     if(map.containsKey(s.charAt(l)))
//                     {
//                         map.put(s.charAt(l),map.get(s.charAt(l))-1);
//                         if(map.get(s.charAt(l))<req.get(s.charAt(l)))
//                         {
//                             count--;
//                             l++;
//                             break;
//                         }
//                     } 
//                     l++;

//                 }  
//             }
//             r++;
//         }
//         return ans;
//     }
// }

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int targetCharsRemaining = t.length();
        int[] minWindow = {0, Integer.MAX_VALUE};
        int startIndex = 0;

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                targetCharsRemaining--;
            }
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            if (targetCharsRemaining == 0) {
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }
                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }

                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                targetCharsRemaining++;
                startIndex++;
            }
        }

        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);        
    }
}