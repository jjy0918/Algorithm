#include <bits/stdc++.h>
#include<unordered_set>

using namespace std;


int dp[2][1000001];

int dir[] = { 'A','B' };

int changeString(int n,int d,string &s) {


	if (dp[d][n] == INT_MAX) {
		if (s[n] == dir[d]) {
			dp[d][n] = min(changeString(n - 1, d,s), changeString(n - 1, d^1,s) + 1);
		}
		else {
			dp[d][n] = min(changeString(n - 1, d, s)+1, changeString(n - 1, d^1, s) + 1);

		}
	}

	return dp[d][n];
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	string s;

	cin >> N >> s;

	fill(&dp[0][0], &dp[0][0] + 2 * 1000001, INT_MAX);

	if (s[0] == 'A') {
		dp[0][0] = 0;
		dp[1][0] = 1;
	}
	else {
		dp[0][0] = 1;
		dp[1][0] = 0;
	}

	cout << changeString(N - 1, 0, s) << endl;




	return 0;
}