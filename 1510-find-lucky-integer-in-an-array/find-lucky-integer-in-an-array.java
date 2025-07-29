class Solution {
    public int findLucky(int[] arr) {
        HashMap <Integer , Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==map.get(arr[i]))
            {
                if(max<arr[i])
                {
                    max=arr[i];
                }
            }
        }
        if(max!=Integer.MIN_VALUE)return max;
        return -1;
    }
}