#include <iostream>
#include <fstream>
using namespace std;

int main() {
	ifstream fin("c:\\windows\\system.ini");
	if (!fin) {
		cout << "error!" << endl;
		return 0;
	}
	int count = 0;
	int ch;
	while ((ch = fin.get()) != EOF) {
		if (ch <= 'z' && ch >= 'a') {
			ch = ch - 'a' + 'A';
		}
		cout << (char)ch;
		count++;
	}
	fin.close();
	return 0;
}