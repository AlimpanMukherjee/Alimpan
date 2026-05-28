class TrieNode
{
    TrieNode[] children = new TrieNode[26];

    int bestlen = Integer.MAX_VALUE;
    int bestidx = Integer.MAX_VALUE;
}

class Solution {

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        TrieNode root = new TrieNode();

        for(int i = 0; i < wordsContainer.length; i++)
        {
            String word = wordsContainer[i];

            TrieNode curr = root;

            if(curr.bestlen > word.length())
            {
                curr.bestlen = word.length();
                curr.bestidx = i;
            }

            for(int j = word.length() - 1; j >= 0; j--)
            {
                int curridx = word.charAt(j) - 'a';

                if(curr.children[curridx] == null)
                {
                    curr.children[curridx] = new TrieNode();
                }

                curr = curr.children[curridx];

                if(curr.bestlen > word.length())
                {
                    curr.bestlen = word.length();
                    curr.bestidx = i;
                }
            }
        }

        int ans[] = new int[wordsQuery.length];

        for(int i = 0; i < wordsQuery.length; i++)
        {
            String word = wordsQuery[i];

            TrieNode curr = root;

            for(int j = word.length() - 1; j >= 0; j--)
            {
                int curridx = word.charAt(j) - 'a';

                if(curr.children[curridx]!=null)curr = curr.children[curridx];
                else if(curr.children[curridx] == null)break;               
            }

            ans[i] = curr.bestidx;
        }

        return ans;
    }
}