#include <bits/stdc++.h>

using namespace std;

int N;
int boards[5001];

int dp[5001];

int evenPalindrome(int start) {

	if (start >= N) {
		return 0;
	}
	if (dp[start] != 0) {
		return dp[start];
	}

	int result = -1;

	for (int i = start + 1; i < N; i += 2) {

		bool isPalindrome = true;

		for (int j = 0; j <= (i - start) / 2; j++) {

			if (boards[start + j] != boards[i - j]) {
				isPalindrome = false;
				break;
			}

		}
		if (isPalindrome) {

			int value = evenPalindrome(i + 1);
			if (value == -1) {
				continue;
			}
			result = max(result, value + 1);

		}

	}


	return dp[start] = result;


}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		boards[i] = a;
	}

	cout << evenPalindrome(0) << endl;

	return 0;
}