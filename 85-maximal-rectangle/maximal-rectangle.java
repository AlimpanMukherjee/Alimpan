class Solution {
    public int findmax(int []nums)
    {
        Stack<Integer> st=new Stack<>();
        int nse[]=new int[nums.length];
        int pse[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])st.pop();
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])st.pop();
            nse[i]=st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]*(nse[i]-pse[i]-1));
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int m=matrix[0].length;//columns
        int n=matrix.length;//rows

        int [][]mat=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='0')mat[i][j]=0;
                else mat[i][j]=1;
            }
        }
        int [][]dummy=new int[n][m];
        // System.out.println(n);
        // System.out.println(m);

        for(int j=0;j<m;j++)
        {
            int total=0;
            for(int i=0;i<n;i++)
            {
                if(mat[i][j]==0)
                {
                    total=0;
                    dummy[i][j]=0;
                }
                else
                {
                    total+=1;
                    dummy[i][j]=total;
                }
            }
        }

        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         System.out.println(dummy[i][j]);
        //     }
        //     System.out.println('\n');
        // }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,findmax(dummy[i]));
        }
        return max;

    }
}