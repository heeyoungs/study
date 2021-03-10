#include <iostream>
using namespace std;

int main() {
    char ch;
    int count = 0;
    while (true) {
        cin.get(ch);
        if (ch == ' ')
            count++;
        if (cin.eof())
            break;
        if (ch == '\n')
            break;
    }
    cout << count;
}