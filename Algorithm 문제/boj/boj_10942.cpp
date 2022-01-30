// boj 10942 팰린드롬?

#include <bits/stdc++.h>

using namespace std;

int arr[2001];
int palindrome[2001][2001];

int findPalindrome(int n1, int n2) {

	if (n1 > n2) {
		return 1;
	}


	if (palindrome[n1][n2] != 0) {
		return palindrome[n1][n2];
	}

	if (arr[n1] == arr[n2]) {
		palindrome[n1][n2] = findPalindrome(n1 + 1, n2 - 1);
	}
	else {
		palindrome[n1][n2] = -1;
	}


	return palindrome[n1][n2];


}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int n;
		cin >> n;
		arr[i] = n;
	}

	cin >> M;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;

		int now = findPalindrome(a - 1, b - 1);
		if (now == -1) {
			cout << 0 << "\n";
		}
		else {
			cout << 1 << "\n";
		}
	}


	return 0;
}