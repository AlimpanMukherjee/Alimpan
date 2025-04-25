int compare(const void *a, const void *b) {
    return (*(int *)b - *(int *)a); 
}
int hIndex(int* a, int n) 
{
    int i,j,HI=0,temp;
    qsort(a, n, sizeof(int), compare);
        for(i=0;i<n;i++)
        {
            if(a[i]>=i+1)
            {
                HI=i+1;
            }
            else
            {
                break;
            }
        }
    return HI;
}
    
