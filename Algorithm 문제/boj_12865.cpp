	/*
	
	백준 12865번 문제 - 평범한 배낭
	https://www.acmicpc.net/problem/12865

	*/

#include <bits/stdc++.h>
#include <string>

using namespace std;

int arr[100][100001];

int solution(vector<pair<int, int>>& bags, int N, int K)
{
	for (int i = bags[0].first; i <= K; i++)
		arr[0][i] = bags[0].second;

	for (int i = 1; i < N; i++)
	{
		for (int j = 1; j <= K; j++)
		{
			// 가방에 넣을 수 있는 경우
			if (j - bags[i].first >= 0)
			{
				arr[i][j] = max(arr[i - 1][j], arr[i-1][j - bags[i].first] + bags[i].second);
			}
			// 가방에 넣을 수 없는 경우
			else
			{
				arr[i][j] = arr[i - 1][j];
			}

		}
	}

	return arr[N-1][K];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N,K;

	vector<pair<int, int>> bags;

	cin >> N >> K;


	for (int i = 0; i < N; i++)
	{
		int k, w;
		cin >> w >> k;
		bags.push_back({ w,k });
	}

	cout << solution(bags, N, K) << endl;

	return 0;
}
