int climbStairs(int n) {
    if(n==1)return 1;
    int total[n+1];
    total[1]=1;
    total[2]=2;
    for(int i=3;i<=n;i++)
    {
        total[i]=total[i-1]+total[i-2];
    }
    return total[n];
}