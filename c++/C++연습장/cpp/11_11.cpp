#include <iostream>
using namespace std;

istream& pos(istream& k) {
	cout << "À§Ä¡´Â? ";
	return k;
}

int main() {
	int x, y;
	cin >> pos >> x;
	cin >> pos >> y;
	cout << x << ',' << y << endl;
}