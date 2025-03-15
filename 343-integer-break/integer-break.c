#include <stdio.h>
#include <math.h>

int integerBreak(int n) {
    int p=1;
    if (n == 2) return 1;
    if (n == 3) return 2;
    while(n>4)
    {
        p=p*3;
        n=n-3;
    }
    return p*n;
}
