#include <iostream>
#include <string>
#include <cstring>
using namespace std;

class Car {
public:
	virtual void action() = 0;
};

class Sedan :public Car {
public:
	void action() {
		cout << "���ϰ� �� �޸���." << endl;
	}
};

class Sports_car :public Car {
public:
	void action() {
		cout << "���ְ� ������." << endl;
	}
};

class Truck :public Car {
public:
	void action() {
		cout << "���� �ƴ´�." << endl;
	}
};

int main() {
	Car* p;
	while (1) {
		string sen;
		if (sen == "Sedan") {
			p = new Sedan;
			p->action();
			delete p;
		}
		else if (sen == "Sports_car") {
			p = new Sports_car;
			p->action();
			delete p;
		}
		else if (sen == "Truck") {
			p = new Truck;
			p->action();
			delete p;
		}
		else if (sen == "stop") {
			break;
		}
	}
}