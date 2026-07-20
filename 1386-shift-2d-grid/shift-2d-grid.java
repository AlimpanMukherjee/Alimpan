class Solution {
    int[] reverse(int []dummy,int i,int j)
    {
        while(i<=j)
        {
            int temp=dummy[j];
            dummy[j]=dummy[i];
            dummy[i]=temp;
            i++;
            j--;
        }
        return dummy;
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;        
        int dummy[]=new int[n*m];        
        int x=0;
        k=k%(n*m);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)ans.add(new ArrayList<>());
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dummy[x]=grid[i][j];
                x++;
            }
        }
        // if(n*m<k)
        // {
        //     x=0;
        //     for(int i=0;i<n;i++)
        //     {
        //         for(int j=0;j<m;j++)
        //         {
        //             ans.get(i).add(dummy[x]);
        //             x++;
        //         }
        //     }
        //     return ans;
        // }
        dummy=reverse(dummy,0,n*m-k-1);
        dummy=reverse(dummy,n*m-k,n*m-1);
        dummy=reverse(dummy,0,n*m-1);
        
        x=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans.get(i).add(dummy[x]);
                x++;
            }
        }
        return ans;
    }
}