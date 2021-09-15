#include <bits/stdc++.h>
#include <cstdlib>
#include<unordered_map>
#include<unordered_set>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, a;

	long long result = LLONG_MAX;

	int arr[3]{ 0,0,0 };

	vector<int> v;
	cin >> N;
	vector<int> number(N);

	for (int i = 0; i < N; i++) {
		cin >> a;
		v.push_back(a);
	}

	number[N - 1] = 1;
	number[N - 2] = 1;

	sort(v.begin(), v.end());

	int initStart = 0;
	int initLast = 1;

	while (initStart<N - 1) {
		int start = initStart + 1, last = initLast - 1;
		long long sum = 0;

		sum += v[initStart];

		sum += v[initLast];


		while (start <= last) {
			int mid = (start + last) / 2;

			if (result > abs(sum + v[mid])) {
				result = abs(sum + v[mid]);
				arr[0] = v[initStart];
				arr[1] = v[mid];
				arr[2] = v[initLast];

			}

			if ((sum + v[mid]) > 0) {
				last = mid - 1;
			}
			else {
				start = mid + 1;
			}

		}

		if (initLast == N - 1) {
			initStart++;
			initLast = initStart + 1;
		}
		else {
			initLast++;
		}

	}


	cout << arr[0] << " " << arr[1] << " " << arr[2] << endl;


	return 0;
}