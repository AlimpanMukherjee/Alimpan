class Solution {
    public int numberOfSpecialChars(String s) {

        Map<Character, Integer> lower = new HashMap<>();
        Map<Character, Integer> upper = new HashMap<>();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {

                lower.put(Character.toUpperCase(ch), i);

            } else {

                upper.putIfAbsent(ch, i);
            }
        }

        for (char ch : upper.keySet()) {

            if (lower.containsKey(ch)) {

                int lastLower = lower.get(ch);
                int firstUpper = upper.get(ch);

                if (firstUpper > lastLower)
                    count++;
            }
        }

        return count;
    }
}