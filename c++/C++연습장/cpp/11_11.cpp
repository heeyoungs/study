#include <iostream>
using namespace std;

istream& pos(istream& k) {
	cout << "��ġ��? ";
	return k;
}

int main() {
	int x, y;
	cin >> pos >> x;
	cin >> pos >> y;
	cout << x << ',' << y << endl;
}