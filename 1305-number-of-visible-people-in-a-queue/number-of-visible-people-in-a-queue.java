class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int []ans=new int[heights.length];
        if(heights.length==1)return new int[1];
        if(heights.length==2)
        {
            ans[0]=1;
            ans[1]=0;
            return ans;
        }
        st.push(heights[n-1]);
        ans[n-1]=0;
        if(heights[n-2]>st.peek())
        {
            st.pop();
        }
        st.push(heights[n-2]);
        ans[n-2]=1;
        for(int i=heights.length-3;i>=0;i--)
        {
            ans[i]=1;
            while(!st.isEmpty() && st.peek()<heights[i])
            {
                ans[i]+=1;
                st.pop();
            }
            if(st.isEmpty())ans[i]-=1;
            st.push(heights[i]);
        }
        return ans;
    }
}