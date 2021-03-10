#include <iostream>
using namespace std;

class BaseMemory {
	char* mem;
protected:
	BaseMemory(int size) { mem = new char[size]; }
	~BaseMemory() { delete[]mem; }
	void setData(int index, char data) { mem[index] = data; }
	char getData(int index) { return mem[index]; }
};

class ROM :public BaseMemory {
private:
	int length;
public:
	ROM(int size,char memory[],int len) : BaseMemory(size){
		length = len;
		for (int i = 0; i < len; i++)
			setData(i, memory[i]);
	}
	char read(int index) { return getData(index); }
};

class RAM :public BaseMemory {
public:
	RAM(int size):BaseMemory(size){}
	void write(int index, int data) { setData(index, data); }
	char read(int index) { return getData(index); }
};

int main() {
	char x[5] = { 'h','e','l','l','o' };
	ROM biosROM(1024 * 10, x, 5);
	RAM mainMemory(1024 * 1024);

	for (int i = 0; i < 5; i++)mainMemory.write(i, biosROM.read(i));
	for (int i = 0; i < 5; i++)cout << mainMemory.read(i);
}