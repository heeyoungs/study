#include <iostream>
using namespace std;

class Circle {
	string name;
	int radius;
public:
	Circle(int radius = 1, string name = "") {
		this->radius = radius;
		this->name = name;
	}
	friend ostream& operator<<(ostream& stream, Circle k);
	friend istream& operator>>(istream& stream, Circle& k);
};

ostream& operator<<(ostream& stream, Circle k) {
	stream << "(반지름" << k.radius << "인 " << k.name << ")";
	return stream;
}

istream& operator>>(istream& stream, Circle& k) {
	cout << "반지름>> ";
	stream >> k.radius;
	cout << "이름>> ";
	stream >> k.name;
	return stream;
}

int main() {
	Circle d, w;
	cin >> d >> w;
	cout << d << w;
}