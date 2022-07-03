#include <stdio.h>

int main(void)
{
    int month, day, code;
    scanf("%d %d", &month, &day);
    code = (month * 2 + day) % 3;
    if (code == 0)
        printf("普通");
    else if (code == 1)
        printf("吉");
    else
        printf("大吉");
}