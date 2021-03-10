#include <iostream>
#include <fstream>
using namespace std;

int main() {
	ifstream fin("test.txt");

	if (!fin) {
		cout << "error!" << endl;
		return 0;
	}
	int count = 0;
	int ch;
	while ((ch = fin.get()) != EOF) {
		cout << (char)ch;
		count++;
	}
	fin.close();
	return 0;
}