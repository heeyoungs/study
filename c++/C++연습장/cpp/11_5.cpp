#include <iostream>
#include <string>
using namespace std;

int main() {
	string cmd;
	cout << "getline" << endl;
	while (true) {
		getline(cin, cmd);
		if (cmd == "exit")
			return 0;
		else
			cin.ignore(1);
	}
}