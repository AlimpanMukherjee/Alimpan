class Solution {
    public int totalNumbers(int[] digits) {
        int even=0;
        Set<Integer> set=new HashSet<>();

        for(int i=0;i<digits.length;i++)
        {
            if(digits[i]==0)continue;
            for(int j=0;j<digits.length;j++)
            {
                if(i!=j)
                {
                    int num1=digits[i]*10+digits[j];                
                    for(int k=0;k<digits.length;k++)
                    {
                        if(i!=k && j!=k)
                        {
                            int num2=0;
                            num2=num1*10+digits[k];
                            if(num2%2==0)set.add(num2);
                        }
                    }
                }
            }           
        }
        return set.size();
    }
}