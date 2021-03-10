#include <iostream>

using namespace std;

int main() {
	char sentence[128];
	int count = 0;
	cin.getline(sentence, 128, '\n');
	int len = strlen(sentence);
	for (int i = 0; i < len; i++) {
		if (sentence[i] == 'a')
			count++;
	}
	cout << count;
}