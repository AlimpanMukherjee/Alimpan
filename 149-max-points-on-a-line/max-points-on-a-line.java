import java.util.*;

class Pair{
    double m,c,k;

    Pair(double k,double m,double c)
    {
        this.m=m;
        this.c=c;
        this.k=k;
    }
}

class Solution {

    boolean check(Pair p, HashSet<String> charset)
    {
        String s =
            p.k + " " +
            p.m + " " +
            p.c;

        if(charset.contains(s))return true;

        charset.add(s);
        return false;
    }

    public int maxPoints(int[][] points) {

        if(points.length==1)return 1;
        if(points.length==2)return 2;

        int n=points.length;

        Set<Pair> set=new HashSet<>();
        HashSet<String> charset=new HashSet<>();

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                double dx=points[j][0]-points[i][0];
                double dy=points[j][1]-points[i][1];

                if(dx==0)
                {
                    Pair p=new Pair(0,-1,points[i][0]);

                    if(!check(p,charset))
                        set.add(p);
                }
                else if(dy==0)
                {
                    Pair p=new Pair(1,0,points[i][1]);

                    if(!check(p,charset))
                        set.add(p);
                }
                else
                {
                    double m=dy/dx;
                    double c=points[i][1]-m*points[i][0];

                    Pair p=new Pair(1,m,c);

                    if(!check(p,charset))
                        set.add(p);
                }
            }
        }

        int maxi=0;

        for(Pair p:set)
        {
            int cnt=0;

            for(int i=0;i<n;i++)
            {
                double lhs=p.k*points[i][1];
                double rhs=p.m*points[i][0]+p.c;

                if(Math.abs(lhs-rhs)<0.000000001)
                {
                    cnt++;
                }
            }

            maxi=Math.max(maxi,cnt);
        }

        return maxi;
    }
}