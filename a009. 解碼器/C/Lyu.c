#include <stdio.h>
int main(void)
{
    char x[1000];
    scanf("%s", &x);
    for (int i = 0; i < strlen(x); i++)
    {
        printf("%c", x[i] - 7);
    }
}