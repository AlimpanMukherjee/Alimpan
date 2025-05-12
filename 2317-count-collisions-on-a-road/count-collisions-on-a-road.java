class Solution {
    public int countCollisions(String directions) {
        int n=directions.length();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            if(directions.charAt(i) == 'L')
           {
                arr[i]=-1;
            }
            if(directions.charAt(i)=='R')
            {
                arr[i]=1;
            }
            if(directions.charAt(i)=='S')
            {
                arr[i]=0;
            }
        }
        
        int count=0,j=-1;
        List<Integer> stck=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int a=arr[i];
            stck.add(a);
            j++;
            while(j>0 && stck.get(j)<stck.get(j-1)){
            int top=stck.get(j);
            if(top<stck.get(j-1))
            {
                if(top==0)count+=1;
                else if(top==-1 && stck.get(j-1)==1)count+=2;
                else if(top==-1 && stck.get(j-1)==0)count+=1;
                stck.remove(j);
                stck.set(stck.size()-1,0);
                j--;
            }
            }
        }



        
        return count;
    }
}