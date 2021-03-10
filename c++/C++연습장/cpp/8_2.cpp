#include <iostream>
#include <string>
using namespace std;

class Circle {
protected:
	int radius;
public:
	Circle(int radius = 0) { this->radius = radius; }
	int getRadius() { return radius; }
	void setRadius(int radius) { this->radius = radius; }
	double getArea() { return 3.14 * radius * radius; }
};

class NamedCircle :public Circle {
	string name;
	static int i;
public:
	NamedCircle() :Circle(radius){
		int radius;
		string name;
		cout << i++<<">> ";
		cin >> radius;
		getline(cin, name);
		setRadius(radius);
		setName(name);
	}
	void setName(string name) { this->name = name; }
	string getName() { return name; }
};

int NamedCircle::i=1;

int main() {
	cout << "5���� ���� �������� ���� �̸��� �Է��ϼ���." << endl;
	NamedCircle pizza[5];
	double max = pizza[0].getArea();
	string name = pizza[0].getName();
	for (int i = 0; i < 5; i++) {
		if (pizza[i].getArea() > max) {
			max = pizza[i].getArea();
			name = pizza[i].getName();
		}
	}
	cout << "���� ������ ū ���ڴ� " << name << "�̸� ���̴� " << max << "�Դϴ�";
}