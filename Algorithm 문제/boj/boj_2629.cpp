	/*
	
	백준 2629 문제 - 양팔저울
	https://www.acmicpc.net/problem/2629
	https://9327144.tistory.com/entry/BOJ-2629-%EC%96%91%ED%8C%94%EC%A0%80%EC%9A%B8-C

	*/
#include <bits/stdc++.h>

using namespace std;

int weights[31];

int N, w, bN;

bool DP[31][31001];

void findWeights() {
	DP[0][15501] = true;
	DP[0][15501 - weights[0]] = true;
	DP[0][15501 + weights[0]] = true;

	for (int i = 1; i < N; i++) {

		int nowWeight = weights[i];

		for (int j = 500; j < 30501; j++) {

			DP[i][j] = DP[i - 1][j - nowWeight] || DP[i - 1][j] || DP[i - 1][j + nowWeight];

		}

	}

}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> w;
		weights[i] = w;
	}
	findWeights();

	cin >> bN;
	for (int i = 0; i < bN; i++) {
		cin >> w;

		if (DP[N - 1][15501 + w]) {
			cout << "Y ";
		}
		else {
			cout << "N ";
		}

	}


	return 0;
}