class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int []nums1=new int[nums.length*2];
        for(int i=0;i<nums.length;i++)
        {
            nums1[i]=nums[i];
        }
        for(int i=nums.length;i<nums1.length;i++)
        {
            nums1[i]=nums[i-nums.length];
        }
        int []output=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for(int i=nums1.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums1[i])st.pop();
            if(i<nums.length)
            {
                output[i]=st.isEmpty()?-1:st.peek();
            }
            st.push(nums1[i]);
        }
        return output;
    }
}