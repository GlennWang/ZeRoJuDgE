#include <stdio.h>
#include <math.h>
int main(void)
{
    int a, b, c, proof, x1, x2;
    scanf("%d %d %d", &a, &b, &c);
    proof = b * b - 4 * a * c;
    if (proof < 0)
        printf("No real root");
    else
    {
        x1 = (-b + sqrt(proof)) / (2 * a);
        x2 = (-b - sqrt(proof)) / (2 * a);
        if (x1 == x2)
            printf("Two same roots x=%d", x1);
        else
            printf("Two different roots x1=%d , x2=%d", x1, x2);
    }
}