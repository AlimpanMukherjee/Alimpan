class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)five+=1;
            if(bills[i]==10)
            {
                ten+=1;
                if(five>0)five-=1;
                else return false;
            }
            if(bills[i]==20)
            {
                if(five>0 && ten>0){
                    ten-=1;
                    five-=1;
                }
                else if(five>2)five-=3;
                else return false;
            }

        }
        return true;
    }
}