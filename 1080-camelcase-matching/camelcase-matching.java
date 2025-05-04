class Solution {

    Boolean check(String a,String pattern)
    {
        int j=0;
        for(int i=0;i<a.length();i++)
        {
            if(j<pattern.length() && pattern.charAt(j)==a.charAt(i))
            {
                j++;
            }
            else if(Character.isUpperCase(a.charAt(i)))
            {
                return false;
            }
        }
        if(j<pattern.length())
        {
            return false;
        }
        return true;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> newlist=new ArrayList<>();

        for(int i=0;i<queries.length;i++)
        {
            newlist.add(check(queries[i],pattern));
        }
        return newlist;
    }
}