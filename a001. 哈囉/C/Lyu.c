#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    char *s = (char *)malloc(1000 * sizeof(char));
    scanf("%s", s);
    printf("hello, %s\n", s);
    free(s);
}