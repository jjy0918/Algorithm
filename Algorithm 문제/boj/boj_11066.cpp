#include <bits/stdc++.h>

using namespace std;

// sum => 사용한 시간
// value => 값
struct node {
	int sum;
	int value;
};

int K;

int resultLast = INT_MAX;

// dp[i][j] => i번째 부터 j까지의 최소 값.
node dp[501][501];

// start부터 last까지 최소 값 구하기
node rec(vector<int> &v, int start, int last) {
	// 인덱스가 하나인 경우 자기 자신 리턴
	if (last == start) {
		return dp[start][last];
	}

	node result = { INT_MAX,0 };
	for (int i = start; i < last; i++) {
		node n1 = dp[start][i];
		node n2 = dp[i + 1][last];
		// 이전에 해당 인덱스를 탐색하지 않은 경우 함수 호출
		if (n1.sum == 0)
			n1 = rec(v, start, i);
		if (n2.sum == 0)
			n2 = rec(v, i + 1, last);
		node now;

		now.value = n1.value + n2.value;
		now.sum = n1.sum + n2.sum + now.value;

		// 시간 중 최소 값 저장
		if (result.sum > now.sum) {
			result = now;
		}
	}
	return dp[start][last] = result;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;
	vector<int> r;
	for (int i = 0; i < T; i++) {
		int K;
		cin >> K;
		int result = 0;
		vector<int> v;

		// dp 초기화
		for (int n1 = 0; n1 <= K; n1++) {
			for (int n2 = 0; n2 <= K; n2++) {
				dp[n1][n2] = { 0,0 };
			}
		}

		for (int j = 0; j < K; j++) {
			int f;
			cin >> f;

			v.push_back(f);
			// dp[j][j] => j,j에서는 값만 존재, 사용한 시간 없음
			dp[j][j] = { 0,f };

		}
		cout << (rec(v, 0, v.size() - 1).sum) << endl;


	}


	return 0;
}
