#include <iostream>
using namespace std;

int main()
{
    // 每個囚犯想的都是實際紅帽是否為看到的紅帽數量+1，因此每過一天就遞增認為的實際數量
    // 只有全部為紅帽才會減少總時長1天
    int prisons, redHats;
    while (cin >> prisons >> redHats) {
        if (prisons != redHats)
            cout << redHats + (prisons != redHats) << endl;
        else
            cout << redHats << endl;
    }
}