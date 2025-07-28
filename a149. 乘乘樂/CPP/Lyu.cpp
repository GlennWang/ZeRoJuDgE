#include <iostream>
using namespace std;

int main()
{
    int tests, number, total = 1;
    cin >> tests;
    for (int i = 0; i < tests; i++) {
        cin >> number;
        do {
            total = total * (number % 10);
            number /= 10;
        } while (number > 0);
        cout << total << endl;
        total = 1;
    }
}