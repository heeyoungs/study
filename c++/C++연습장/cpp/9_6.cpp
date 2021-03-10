#include <iostream>
using namespace std;

class AbstractStack {
public:
	virtual bool push(int n) = 0;
	virtual bool pop(int& n) = 0;
	virtual int size() = 0;
};

class IntStack :public AbstractStack {
	int* stack;
	int top;
	int max;
public:
	IntStack(int n) { stack = new int[n]; max = n; top = -1; }
	bool push(int n) {
		if (top == max)return false;
		else {
			top++;
			stack[top] = n;
			return true;
		}
	};
	bool pop(int& n) {
		if (top < 0)return false;
		else {
			n = stack[top];
			top--;
			return true;
		}
	};
	int size() { return top + 1; };
};

int main() {
	IntStack intstack(50);
	int re;
	intstack.push(10);
	intstack.push(20);
	intstack.push(30);
	intstack.push(40);
	cout << "현재 원소 개수 : " << intstack.size() << "개" << endl;
	intstack.pop(re);
	cout << "pop : " << re << endl;
	intstack.pop(re);
	cout << "pop : " << re << endl;
	intstack.pop(re);
	cout << "pop : " << re << endl;
	cout << "현재 원소 개수 : " << intstack.size() << "개" << endl;
}