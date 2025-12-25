class Solution {
    Set<Integer> s=new HashSet<>();
    public boolean canReach(int[] arr, int start) {

        if(start<0 || start>=arr.length)return false;
        if(arr[start]==0)return true;
        if(s.contains(start))return false;
        else s.add(start);
        // boolean left=canReach(arr,start-arr[start]);
        // boolean right=canReach(arr,start+arr[start]);
        // if(left || right)return true;
        if(canReach(arr,start-arr[start]) || canReach(arr,start+arr[start]))return true;
        else return false;

    }
}