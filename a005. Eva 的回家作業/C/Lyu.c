#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int lines, nowline, num_arr[5];
    scanf("%d", &lines);
    for (nowline = 0; nowline < lines; nowline++)
    {
        scanf("%d %d %d %d", &num_arr[0], &num_arr[1], &num_arr[2], &num_arr[3]);
        num_arr[4] = (num_arr[1] - num_arr[0] == num_arr[2] - num_arr[1]) ? (2 * num_arr[3] - num_arr[2]) : (num_arr[3] * (num_arr[3] / num_arr[2]));
        printf("%d %d %d %d %d\n", num_arr[0], num_arr[1], num_arr[2], num_arr[3], num_arr[4]);
    }
}