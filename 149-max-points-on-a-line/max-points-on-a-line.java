import java.util.*;

class Pair{
    double m,c,k;

    Pair(double k,double m,double c)
    {
        this.m=m;
        this.c=c;
        this.k=k;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this==obj)return true;
        if(obj==null || getClass()!=obj.getClass())return false;

        Pair p=(Pair)obj;

        return Math.abs(k-p.k)<1e-9 && Math.abs(m-p.m)<1e-9 && Math.abs(c-p.c)<1e-9;
    }

    @Override
    public int hashCode()
    {
        long a=Math.round(k*1e9);
        long b=Math.round(m*1e9);
        long d=Math.round(c*1e9);

        return Objects.hash(a,b,d);
    }
}

class Solution {

    public int maxPoints(int[][] points) {

        if(points.length==1)return 1;
        if(points.length==2)return 2;

        int n=points.length;

        Set<Pair> set=new HashSet<>();

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                double dx=points[j][0]-points[i][0];
                double dy=points[j][1]-points[i][1];

                if(dx==0)
                {
                    Pair p=new Pair(0,-1,points[i][0]);
                    set.add(p);
                }
                else if(dy==0)
                {
                    Pair p=new Pair(1,0,points[i][1]);
                    set.add(p);
                }
                else
                {
                    double m=dy/dx;
                    double c=points[i][1]-m*points[i][0];
                    Pair p=new Pair(1,m,c);
                    set.add(p);
                }
            }
        }

        int maxi=2;

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