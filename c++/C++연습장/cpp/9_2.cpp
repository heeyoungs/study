#include <iostream>
#include <string>
using namespace std;

class Converter {
protected:
	double ratio;
	virtual double convert(double src) = 0;
	virtual string getSourceString() = 0;
	virtual string getDestString() = 0;
public:
	Converter(double ratio) { this->ratio = ratio; }
	void run() {
		double src;
		cout << getSourceString() << "을 " << getDestString() << "로 바꿉니다. ";
		cout << getSourceString() << "을 입력하세요>> ";
		cin >> src;
		cout << "변환 결과 : " << convert(src) << getDestString() << endl;
	}
};

class KmToMile :public Converter {
public:
	KmToMile(double ratio) :Converter(ratio) {}
	string getSourceString() { return "Km"; }
	string getDestString() { return "Mile"; };
	double convert(double src) { src = src / 1.609344; return src; }
};

int main() {
	KmToMile toMile(1.609344);
	toMile.run();
}