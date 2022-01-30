	/*
	
	백준 1012번 문제 - 유기농 배추
	https://www.acmicpc.net/problem/1012

	*/
#include <bits/stdc++.h>

using namespace std;

bool isVisit[51][51];

int dx[4]{ 0,0,1,-1 };
int dy[4]{ 1,-1,0,0 };

void bfs(vector<vector<int>> &boards, int x, int y, int M,int N)
{
	queue<pair<int, int>> q;

	int nx, ny;

	q.push({ x,y });
	isVisit[x][y] = true;

	while (!q.empty())
	{
		pair<int, int> p;
		p = q.front();
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			nx = p.first + dx[i];
			ny = p.second + dy[i];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N && boards[nx][ny] && !isVisit[nx][ny])
			{
				isVisit[nx][ny] = true;
				q.push({ nx, ny });
			}

		}
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, M, N, K;
	int x, y;

	int result=0;

	cin >> T;
	vector<vector<vector<int>>> boards(T);
	vector<int> vM(T);
	vector<int> vN(T);

	for (int t = 0; t < T; t++)
	{
		cin >> M >> N >> K;
		vM[t] = M;
		vN[t] = N;
		boards[t] = vector<vector<int>>(M, vector<int>(N));

		for (int i = 0; i < K; i++)
		{
			cin >> x >> y;

			boards[t][x][y] = 1;
		}
		
	}


	for (int t = 0; t < T; t++)
	{
		M = vM[t];
		N = vN[t];
		fill(&isVisit[0][0], &isVisit[0][0] + 51 * 51, false);
		result = 0;
		

		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (boards[t][i][j] && !isVisit[i][j])
				{
					bfs(boards[t], i, j, M, N);
					result++;
				}
			}
		}

		cout << result << endl;
	}


	return 0;
}