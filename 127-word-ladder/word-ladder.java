
class Solution {

    int compare(String a, String b) {

        int count = 0;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {

        int n = wordList.size();

        int found = 0;

        for (String s : wordList) {

            if (s.equals(endWord)) {
                found = 1;
                break;
            }
        }

        if (found == 0)
            return 0;

        Queue<String> q = new LinkedList<>();

        int visited[] = new int[n];

        q.offer(beginWord);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                String word = q.poll();

                if (word.equals(endWord))
                    return level;

                for (int i = 0; i < n; i++) {

                    if (visited[i] == 0 &&
                        compare(word, wordList.get(i)) == 1) {

                        visited[i] = 1;

                        q.offer(wordList.get(i));
                    }
                }
            }

            level++;
        }

        return 0;
    }
}