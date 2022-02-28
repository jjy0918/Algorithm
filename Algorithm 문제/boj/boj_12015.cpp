#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

int numbers[1000001];

vector<int> bb;

int main()
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;

	cin >> N;

	int a;

	int maxLength = 0;
	int index = 0;

	for (int i = 0; i < N; i++) {
		cin >> a;
		numbers[i] = a;
	}

	bb.push_back(numbers[0]);
	for (int i = 1; i < N; i++) {
		int left = 0;
		int right = bb.size() - 1;


		while (left <= right) {
			int mid = (left + right) / 2;

			if (bb[mid] == numbers[i]) {
				left = mid;
				break;
			}
			else if (bb[mid] > numbers[i]) {
				right = mid - 1;

			}
			else {
				left = mid + 1;
			}
		}

		if (left >= bb.size())
			bb.push_back(numbers[i]);
		else
			bb[left] = numbers[i];
	}


	cout << bb.size() << endl;




	return 0;
}


/*
c++ 난수 생성
srand((unsigned int)time(0));

0~99 난수
int r1 = rand() % 100;

*/
