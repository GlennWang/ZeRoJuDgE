#include <stdio.h>
int main(void)
{
    int line;
    scanf("%d", &line);
    int n[line][5];
    for (int i = 0; i < line; i++)
    {
        scanf("%d %d %d %d", &n[i][0], &n[i][1], &n[i][2], &n[i][3]);
        n[i][4] = (n[i][1] - n[i][0] == n[i][2] - n[i][1]) ? (2 * n[i][3] - n[i][2]) : (n[i][3] * (n[i][3] / n[i][2]));
    }
    for (int i = 0; i < line; i++)
    {
        for (int j = 0; j < 4; j++)
            printf("%d ", n[i][j]);
        printf("%d\n", n[i][4]);
    }
}