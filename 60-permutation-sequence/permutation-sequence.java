class Solution {
    public void reverse(int[] a, int start, int end) {
        end--; 
        while (start < end) 
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] a,int k) {
        int n = a.length;
        int index = -1;
        if(k==1) return;
        for (int i = n - 2; i >= 0; i--) 
        {
            if (a[i] < a[i + 1]) 
            {
                index = i;
                break;
            }
        }
        if (index == -1) 
        {
            reverse(a, 0, n);
            return;
        }
        int nextGreater = -1;
        for (int i = n - 1; i > index; i--) 
        {
            if (a[i] > a[index]) 
            {
                nextGreater = i;
                break;
            }
        }
        int temp = a[index];
        a[index] = a[nextGreater];
        a[nextGreater] = temp;

        reverse(a, index + 1, n);
        nextPermutation(a,k-1);
    }

    public String getPermutation(int n, int k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) 
        {
            a[i] = i + 1;
        }
            nextPermutation(a,k);
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=ans*10+a[i];
        }
        return Integer.toString(ans);
    }
}
