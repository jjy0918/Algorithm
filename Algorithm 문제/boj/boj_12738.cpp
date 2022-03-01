#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

long long numbers[1000001];

long long D[1000001];

int main()
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;

	cin >> N;

	int a;
	for (int i = 0; i < N; i++) {
		cin >> a;
		numbers[i] = a;
	}

	D[0] = numbers[0];

	int maxLength = 1;

	for (int i = 1; i < N; i++) {
		int left = 0;
		int right = maxLength - 1;


		while (left <= right) {
			int mid = (left + right) / 2;

			if (D[mid] == numbers[i]) {
				left = mid;
				break;
			}
			else if (D[mid] > numbers[i]) {
				right = mid - 1;

			}
			else {
				left = mid + 1;
			}
		}

		D[left] = numbers[i];
		maxLength = max(maxLength, left + 1);


	}



	cout << maxLength << endl;




	return 0;
}


/*
c++ 난수 생성
srand((unsigned int)time(0));

0~99 난수
int r1 = rand() % 100;

*/
