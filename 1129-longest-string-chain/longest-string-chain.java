class Solution {
    boolean compare(String s1,String s2)
{
    int len1=s1.length();
    int len2=s2.length();

    if(len1-len2!=1)return false;

    int i=0;
    int j=0;

    while(i<len1)
    {
        if(j<len2 && s1.charAt(i)==s2.charAt(j))
        {
            i++;
            j++;
        }
        else
        {
            i++;
        }
    }

    return i==len1 && j==len2;
}

    public int longestStrChain(String[] words)
    {
        int n=words.length;

        int maxi=1;

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int dp[]=new int[n];

        Arrays.fill(dp,1);

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(compare(words[i],words[j]))
                {
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]=dp[j]+1;
                    }

                    maxi=Math.max(maxi,dp[i]);
                }
            }
        }

        return maxi;
    }
}