#include <stdio.h>

int main()
{
    int num, x = 2, ans[1000] = {0}, i = 0;
    scanf("%d", &num);
    while (num != 1)
    {
        if (num % x == 0)
        {
            num /= x;
            ans[i] = x;
            // printf("%d",x);
            i += 1;
            x = 2;
        }
        else
        {
            x += 1;
        }
    }
    int last = ans[0], count = 1;
    for (int j = 1; j <= i; j++)
    {
        if (last != ans[j])
        {
            if (count != 1)
            {
                printf("%d^%d", last, count);
                count = 1;
            }
            else
            {
                printf("%d", last);
            }
            last = ans[j];
            if (j != i)
            {
                printf(" * ");
            }
        }
        else
        {
            count += 1;
        }
    }
}