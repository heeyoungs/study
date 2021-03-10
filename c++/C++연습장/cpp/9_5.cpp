#include <iostream>
using namespace std;

class AbstractGate {
protected:
	bool x, y;
public:
	void set(bool x, bool y) { this->x = x; this->y = y; }
	virtual bool operation() = 0;
};

class AndGate : public AbstractGate {
public:
	bool operation() {
		if (x == 1 && y == 1) {
			return 1;
		}
		else return 0;
	}
};

class OrGate : public AbstractGate {
public:
	bool operation() {
		if (x == 0 && y == 0) {
			return 0;
		}
		else return 1;
	}
};

class XorGate : public AbstractGate {
public:
	bool operation() {
		if ((x == 0 && y == 0) || (x == 1 && y == 1)) {
			return 0;
		}
		else return 1;
	}
};

int main() {
	AndGate And;
	OrGate Or ;
	XorGate Xor;

	And .set(true, false);
	Or .set(true, false);
	Xor .set(true, false);
	cout.setf(ios::boolalpha);
	cout << And.operation() << endl;
	cout << Or.operation() << endl;
	cout << Xor.operation() << endl;
}