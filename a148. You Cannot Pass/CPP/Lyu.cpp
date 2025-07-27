#include <iostream>
using namespace std;

int main()
{
    int scoreCount, score;
    while (cin >> scoreCount) {
        float totalScore = 0;
        for (int i = 0; i < scoreCount; i++) {
            cin >> score;
            totalScore += score;
        }
        if (totalScore / scoreCount > 59)
            cout << "no" << endl;
        else
            cout << "yes" << endl;
    }
}