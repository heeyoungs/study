#include <iostream>
#include <string>
using namespace std;

class Point {
	int x, y;
public:
	Point() { }
	Point(int x, int y) { this->x = x; this->y = y; }
	int getX() { return x; }
	int getY() { return y; }
protected:
	void move(int x, int y) { this->x = x; this->y = y; }
};

class ColorPoint :public Point {
private:
	int x, y;
	string color;
public:
	ColorPoint() :Point() { x = 0; y = 0; color = "BLACK"; }
	ColorPoint(int x, int y, string color) : Point(x, y) {
		this->x = x;
		this->y = y;
		this->color = color;
	}
	void setPoint(int x, int y) { this->x = x; this->y = y; }
	void setColor(string color) { this->color = color; }
	void show() { cout << color << "색으로 (" << x << "," << y << ")에 위차한 점입니다."<<endl; }
};

int main() {
	ColorPoint zeroPoint;
	zeroPoint.show();

	ColorPoint cp(5, 5, "RED");
	cp.setPoint(10, 20);
	cp.setColor("BLUE");
	cp.show();
}