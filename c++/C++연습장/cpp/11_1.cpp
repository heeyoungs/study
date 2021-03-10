#include <iostream>
using namespace std;

int main() {
	int ch;
	int count = 0;
	while ((ch = cin.get()) != EOF) {
		if (ch == 'a') {
			count++;
		}
		if (ch == '\n')
			break;
	}
	cout << count;
}