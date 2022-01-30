#include <bits/stdc++.h>

using namespace std;

int N, M;

int heights[51][51];

int result[51][51];


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < M; j++) {


			heights[i][j] = s[j] - '0';
		}
	}

	int dy[] = { -1,-1,0,1,1,1,0,-1 };
	int dx[] = { 0,1,1,1,0,-1, -1, -1 };

	int ddy[] = { 0,0,-1,1 };
	int ddx[] = { 1,-1,0,0 };

	// 돌아서 가장 높은 값으로 조정
	for (int h = 2; h <= 9; h++) {
		int groupNumber[51][51];
		fill(&groupNumber[0][0], &groupNumber[0][0] + 51 * 51, 0);

		bool isHeight = false;

		// 높이가 정확히 h인 장벽 세우기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (groupNumber[i][j] == 0 && heights[i][j] == h) {
					isHeight = true;
					queue<pair<int, int>> q;
					q.push({ i,j });
					groupNumber[i][j] = h;

					// 높이가 h 이상인 부분을 bfs로 탐색하여 표시한다.
					while (!q.empty()) {
						int y = q.front().first;
						int x = q.front().second;
						q.pop();

						for (int p = 0; p < 8; p++) {
							int ny = y + dy[p];
							int nx = x + dx[p];
							if (ny < 0 || nx < 0 || ny >= N || nx >= M || groupNumber[ny][nx] != 0 || heights[ny][nx] < h) {
								continue;
							}
							q.push({ ny,nx });
							groupNumber[ny][nx] = h;
						}
					}



				}
			}
		}

		// 해당 높이의 땅이 없으면 밑의 과정은 생략한다.
		if (!isHeight)
			continue;



		// 가장자리와 연결된 부분은 -1로 표시
		queue<pair<int, int>> q;
		for (int y = 0; y < N; y++) {
			int x = 0;
			if (groupNumber[y][x] == 0) {
				groupNumber[y][x] = -1;
				q.push({ y,x });
			}

			x = M - 1;
			if (groupNumber[y][x] == 0) {
				groupNumber[y][x] = -1;
				q.push({ y,x });
			}

		}
		for (int x = 0; x < M; x++) {
			int y = 0;
			if (groupNumber[y][x] == 0) {
				groupNumber[y][x] = -1;
				q.push({ y,x });
			}
			y = N - 1;
			if (groupNumber[y][x] == 0) {
				groupNumber[y][x] = -1;
				q.push({ y,x });
			}
		}

		// 가장자리와 연결된 부분은 수영장을 만들 수 없다.
		// 가장자리와 연결된 부분 -1로 표시
		while (!q.empty()) {
			int y = q.front().first;
			int x = q.front().second;
			q.pop();


			for (int p = 0; p < 4; p++) {
				int ny = y + ddy[p];
				int nx = x + ddx[p];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || groupNumber[ny][nx] != 0) {
					continue;
				}
				if (groupNumber[ny][nx] == -1)
					continue;
				q.push({ ny,nx });
				groupNumber[ny][nx] = -1;
			}
		}

		// 장벽인 부분 && 가장자리와 연결된 부분을 제외한 부분이 수영장이 된다.
		// 해당 인덱스에서 장벽의 높이에 땅의 높이를 뺀 부분을 저장한다.
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (groupNumber[y][x] == 0) {
					groupNumber[y][x] = h - heights[y][x];
				}
			}

		}

		// 기존에 저장해 놓은 것에서 중복된 부분이 있으면 덮어씌워준다.
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (groupNumber[y][x] != -1 && groupNumber[y][x] != h && result[y][x] < groupNumber[y][x]) {
					result[y][x] = groupNumber[y][x];
				}
			}

		}
	}

	// 수영장의 최종 높이를 더한다.
	int resultSum = 0;
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			resultSum += result[y][x];
		}

	}
	cout << resultSum << endl;

	return 0;
}

