#include <bits/stdc++.h>
#include<unordered_set>

using namespace std;

int leftHeights[11];


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N,n;

	vector<int> arr;

	cin >> N;

	for (int i = 0; i < N; i++) {
		arr.push_back(i);
		cin >> n;
		leftHeights[i] = n;
	}

	do {
		bool isOrder = true;
		for (int i = 0; i < N&&isOrder; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					sum++;
				}
			}
			if (sum != leftHeights[arr[i]]) {
				isOrder = false;
			}
		}

		if (isOrder) {
			for (int i = 0; i < N; i++) {
				cout << arr[i] + 1 << " ";
			}
			cout << endl;
		}
	} while (next_permutation(arr.begin(), arr.end()));


	return 0;
}