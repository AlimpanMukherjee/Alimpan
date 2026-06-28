class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        // for(int num:arr)
        // {
        //     if(map.containsKey(num))map.put(num,map.get(num)+1);
        //     else map.put(num,1);
        // }    
        Arrays.sort(arr);
        arr[0]=1;
        for(int i=1;i<arr.length;i++)
        {
            int opt1=arr[i-1]+1;
            //int opt2=arr[i-1]-1;
            int max_allow=arr[i];
            if(opt1<=max_allow)arr[i]=opt1;
            //else arr[i]=opt2;
        }
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
        return arr[arr.length-1];
    }
}