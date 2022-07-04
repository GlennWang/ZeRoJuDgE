#include <stdio.h>
#include <iostream>
using namespace std;

int daycount(int year, int month, int day)
{
    int before, other, sum = 0;
    before = year - 1;          //目標年與目標年之前分開計算。
    sum += (before / 400) * 97; //每400年有97閏年。
    sum += before * 365;        //每1年有365天。
    other = before % 400;       // 400循環之外的年份。
    sum += other / 4;           //每4年1閏年。
    sum -= other / 100;         // 100、200、300為平年。
    /*or
    sum += before * 365;
    sum += before / 400;
    sum += before / 4;
    sum -= before / 100;
    */

    //月份1.12不算
    /*
    int dayofmonth[12] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    for (int i = 1; i < month; i++)
    {
        sum += dayofmonth[i];
    }
    */

    int dayofmonth[12] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    sum += dayofmonth[month - 1];

    sum += day;

    if (month > 2 && (((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0))
    {
        return sum + 1;
    }
    else
    {
        return sum;
    }
}
int main()
{
    int y1, y2, m1, m2, d1, d2, c1, c2;

    while (cin >> y1 >> m1 >> d1 >> y2 >> m2 >> d2)
    {
        c1 = daycount(y1, m1, d1);
        c2 = daycount(y2, m2, d2);
        cout << abs(c1 - c2) << endl;
    }

    return 0;
}