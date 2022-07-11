#include <stdio.h>
#include <stdlib.h>

int decodeRoma(char chr, int *pos);
int encodeRoma(int number);

int main(void)
{
    char chr;
    int num[2] = {0, 0}, indexOfNum = 0;
    int current_pos = 7, previous_pos = 7;
    int decode_num[7] = {1, 5, 10, 50, 100, 500, 1000};
    scanf("%c", &chr);
    while (1)
    {
        if (chr == '#') // end loop
            break;
        else if (chr == 10) // '\0'
        {
            int result = num[0] - num[1];
            if (result < 0)
                result = -result;
            encodeRoma(result);
            num[0] = num[1] = indexOfNum = 0;
            current_pos = previous_pos = 7;
        }
        else if (chr == ' ')
        {
            indexOfNum++;
            current_pos = previous_pos = 7;
        }
        else
        {
            num[indexOfNum] += decodeRoma(chr, &current_pos);
            if (current_pos > previous_pos)
                num[indexOfNum] -= 2 * decode_num[previous_pos];
            previous_pos = current_pos;
        }
        scanf("%c", &chr);
    }
}

int decodeRoma(char chr, int *pos)
{
    char code[7] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int number = 1;
    for (int i = 0; i < 7; i++)
    {
        if (chr == code[i])
        {
            *pos = i;
            return number;
        }
        number *= (i % 2 == 0) ? 5 : 2;
    }
    printf("%c is not in decode list\n", chr);
    return -1;
}

int encodeRoma(int number)
{
    char code[7] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int code_ptr[4] = {6, 4, 2, 0};
    int digit = 1000, current_num = 0;
    for (int i = 0; i < 4; i++)
    {
        current_num = number / digit % 10;
        if (current_num <= 3)
        {
            for (int j = 0; j < current_num; j++)
                printf("%c", code[code_ptr[i]]);
        }
        else if (current_num == 4)
        {
            printf("%c%c", code[code_ptr[i]], code[code_ptr[i] + 1]);
        }
        else if (current_num <= 8)
        {
            printf("%c", code[code_ptr[i] + 1]);
            for (int j = 0; j < current_num - 5; j++)
                printf("%c", code[code_ptr[i]]);
        }
        else if (current_num == 9)
        {
            printf("%c%c", code[code_ptr[i]], code[code_ptr[i] + 2]);
        }
        digit /= 10;
    }
    if (number == 0)
        printf("ZERO");
    printf("\n");
    return 0;
}