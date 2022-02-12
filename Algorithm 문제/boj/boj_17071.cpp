#include <bits/stdc++.h>
#include <unordered_set>

using namespace std;

int SSize;
int TSize;

int boards[500001][2];


int main()
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K;

	cin >> N >> K;

	if (N == K) {
		cout << 0 << endl;
		return 0;
	}

	fill(&boards[0][0], &boards[0][0] + 500001 * 2, INT_MAX);


	queue<pair<int, int>> q;
	boards[N][0] = 0;
	q.push({ N,0 });



	while (!q.empty()) {
		int nowIndex = q.front().first;
		int nowCnt = q.front().second;

		q.pop();


		int nextNum[3] = { nowIndex - 1,nowIndex + 1,nowIndex * 2 };

		for (int i = 0; i < 3; i++) {
			int number = nextNum[i];
			int nxtCnt = nowCnt + 1;
			if (nextNum[i] < 0 || nextNum[i] > 500000) {
				continue;
			}

			if (boards[number][nxtCnt % 2] == INT_MAX) {
				boards[number][nxtCnt % 2] = nxtCnt;
				q.push({ number,nowCnt + 1 });
			}
		}

	}

	int cnt = 0;
	int result = -1;
	while (K <= 500000) {

		if (boards[K][cnt % 2] <= cnt) {

			result = cnt;
			break;
		}
		cnt++;
		K += cnt;


	}



	cout << result << endl;


	return 0;
}

