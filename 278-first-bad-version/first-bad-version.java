/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1;
        int right=n;
        int ans=left;
        while(left<=right)
        {
            int mid=left-(left-right)/2;
            if(isBadVersion(mid))
            {
                right=mid-1;
            }
            else
            {
                ans=left;
                left=mid+1;
                
            }
        }
        return left;

    }
}