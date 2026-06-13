class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int nums[]=new int[words.length];
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
                nums[i]+=weights[words[i].charAt(j)-'a'];
            }
            nums[i]=nums[i]%26;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            char c=(char)('z'-nums[i]);
            ans.append(c); 
        }
        return ans.toString();
    }
}