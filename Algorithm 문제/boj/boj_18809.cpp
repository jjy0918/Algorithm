	/*
	
	백준 18809 문제 - 유기농 배추
	https://www.acmicpc.net/problem/18809
	https://9327144.tistory.com/entry/BOJ-18809-Gaaaaaaaaaarden-C

	*/
#include <bits/stdc++.h>

using namespace std;

#define GREEN 3
#define RED 4
#define FLOWER 5

// 땅의 정보. 
// color => 땅의 색, time => 해당 땅에 배양액이 뿌려진 시간.
struct myPoint {
	int color;
	int time;

};

int dx[]{ 0,0,-1,1 };
int dy[]{ 1,-1,0,0};

int N;
int M;

// 배양액이 뿌려질 수 있는 땅의 위치
vector<pair<int, int>> colorPoint;

// 땅의 정보가 담겨 있는 벡터
vector<vector<myPoint>> baseV;

int bfs( vector<vector<myPoint>> v)
{
	queue<pair<int,int>> q;

	pair<int, int> nowNode;

	int result = 0;

	for (int i = 0; i<N; i++)
	{

		for (int j = 0; j < M; j++)
		{
			// 배양액이 초기에 뿌려진 위치를 큐에 넣는다.
			if (v[i][j].color == RED || v[i][j].color == GREEN)
				q.push({ i, j });
		}

	}

	while (!q.empty())
	{
		nowNode = q.front();
		q.pop();

		int x = nowNode.first;
		int y = nowNode.second;

		// 해당 위치에 꽃이 피어 있다면, 더 이상 퍼지지 않는다.
		if (v[x][y].color == FLOWER)
			continue;

		for (int di = 0; di < 4; di++)
		{
			int nx = x + dx[di];
			int ny = y + dy[di];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M && v[nx][ny].color!=0 && v[nx][ny].color!=FLOWER)
			{
				// 해당 땅에 배양액에 뿌려지지 않은 경우
				if (v[nx][ny].color==1)
				{
					q.push({ nx,ny });
					v[nx][ny].color = v[x][y].color;
					v[nx][ny].time = v[x][y].time+1;
				}

				// 해당 땅에 배양액이 뿌려져 있고,
				// 해당 배양액이 지금 퍼지고 있는 배양액과 다르고, 뿌려지는 시간이 같은 경우
				else if ((v[nx][ny].color != v[x][y].color) && (v[x][y].time+1 == v[nx][ny].time))
				{
					result++;
					v[nx][ny].color = FLOWER;
				}

			}
		}
	}

	return result;
}

// 배양액이 뿌려질 수 있는 땅에 
// 어떠한 배양액이 뿌려져야 하는지 모든 경우를 계산
int solution(int R,int G, int index, vector<int> col)
{
	int result = 0;

	// 남아 있는 배양액 보다, 뿌려질 수 있는 땅의 개수가 적은 경우
	if (R + G > col.size() - index)
		return -1;
	
	// 모든 땅을 모두 살펴본 경우 BFS를 실행시킨다.
	if (index==col.size())
	{	
		vector<vector<myPoint>> v(baseV);

		for (int i = 0; i < col.size(); i++)
		{
			int x = colorPoint[i].first;
			int y = colorPoint[i].second;

			v[x][y].color = col[i];
		}

		return bfs(v);
	}


	// 땅에 빨간색 배양액을 뿌리는 경우.
	if (R > 0)
	{
		col[index] = RED;

		result = max(result, solution(R-1, G, index + 1, col));

		col[index] = 1;
	}

	// 땅에 초록색 배양액을 뿌리는 경우.
	if(G > 0)
	{
		col[index] = GREEN;

		result = max(result, solution(R, G-1, index + 1, col));

		col[index] = 1;
	}

	result = max(result, solution(R, G, index + 1, col));

	return result;
}




int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int C;
	int R, G;

	cin >> N;
	cin >> M;
	
	cin >> G;
	cin >> R;

	vector<int> v;

	for (int i = 0; i<N; i++)
	{
		baseV.push_back({});
		for (int j = 0; j < M; j++)
		{
			cin >> C;

			baseV[i].push_back({ C,0 });

			// 배양액이 뿌려질 수 있는 땅을 따로 저장해 놓는다.
			if (C == 2)
			{
				colorPoint.push_back({ i,j });
				v.push_back(1);
			}

		}
	}

	cout << solution(R, G, 0, v) << endl;

	return 0;
}
