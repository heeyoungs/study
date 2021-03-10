#include <iostream>
using namespace std;

class Phone {
	string name;
	string telnum;
	string address;
public:
	Phone(string name = "", string telnum = "", string address = "") {
		this->name = name;
		this->telnum = telnum;
		this->address = address;
	}
	friend ostream& operator<<(ostream& stream, Phone k);
	friend istream& operator>>(istream& stream, Phone& k);
};

ostream& operator<<(ostream& stream, Phone k) {
	stream << "(" << k.name << "," << k.telnum << "," << k.address << ")";
	return stream;
}

istream& operator>>(istream& stream, Phone& k) {
	cout << "이름:";
	stream >> k.name;
	cout << "전화번호:";
	stream >> k.telnum;
	cout << "주소:";
	stream >> k.address;
	return stream;
}

int main() {
	Phone girl, boy;
	cin >> girl >> boy;
	cout << girl << endl << boy << endl;
}