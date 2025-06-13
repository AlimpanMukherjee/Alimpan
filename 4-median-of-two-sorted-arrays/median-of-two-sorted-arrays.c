double findMedianSortedArrays(int* a, int n, int* b, int m) {
    int i=0, j=0,k=0,c[n+m];
    while (i < n && j < m) {
        if (a[i] < b[j]) {
            c[k] = a[i];
            i++;
        } else {
            c[k] = b[j];
            j++;
        }
        k++;
    }
    while (i < n ) {
        c[k] = a[i];
        k++;
        i++;
    }
    while (j < m) {
        c[k] = b[j];
        k++;
        j++;
    }
    if((n+m)%2==0)
    {
        return (c[(n+m)/2]+c[(n+m)/2-1])/2.0; 
    }
    else
    {
        return c[(n+m)/2];
    }
}