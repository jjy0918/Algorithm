	/*
	
	백준 3197번 문제 - 백조의 호수
	https://www.acmicpc.net/problem/3197

	*/


#include <bits/stdc++.h>

using namespace std;

int SwanLakeNum1;
int SwanLakeNum2;

struct LAKE {
	int lakeNum;
	int time;

};

vector<vector<LAKE>> boards;

vector<int> lakeParent;
vector<int> lakeParentHeight;

int dx[]{ 0,0,-1,1 };
int dy[]{ 1,-1,0,0};

int findParent(int n)
{
	if (lakeParent[n] == n)
		return lakeParent[n];

	return lakeParent[n] = findParent(lakeParent[n]);
}

void unionParent(int n1, int n2)
{
	int parentNode1 = findParent(n1);
	int parentNode2 = findParent(n2);

	if (parentNode1 == parentNode2)
		return;


	if (lakeParentHeight[parentNode1] == lakeParentHeight[parentNode2])
	{
		lakeParentHeight[parentNode1]++;
		lakeParent[parentNode2] = parentNode1;
	}
	else if (lakeParentHeight[parentNode1] > lakeParentHeight[parentNode2])
	{
		lakeParent[parentNode2] = parentNode1;
	}
	else
	{
		lakeParent[parentNode1] = parentNode2;
	}



}

bool isSameParent(int n1, int n2)
{
	return findParent(n1) == findParent(n2);
}

int solution(int R, int C, vector<pair<int, int>> &v)
{
	

	int number = 0;

	queue<pair<int, int>> findQ;


	for (int i = 0; i < R; i++)
	{

		for (int j = 0; j < C; j++)
		{
			if (boards[i][j].lakeNum == -1)
			{
				queue<pair<int, int>> q;
				q.push({ i,j });
				boards[i][j].lakeNum = number;
				lakeParent.push_back(number);
				lakeParentHeight.push_back(1);


				while (!q.empty())
				{
					int x = q.front().first;
					int y = q.front().second;
					q.pop();

					if (x == v[0].first && y == v[0].second)
						SwanLakeNum1 = number;

					else if (x == v[1].first && y == v[1].second)
						SwanLakeNum2 = number;

					int count = 0;

					for (int p = 0; p < 4; p++)
					{
						int nextX = x + dx[p];
						int nextY = y + dy[p];

						if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C)
						{
							if (boards[nextX][nextY].lakeNum == -1)
							{
								q.push({ nextX,nextY });
								boards[nextX][nextY].lakeNum = number;
							}
							else if (boards[nextX][nextY].lakeNum == -2 && count == 0)
							{
								findQ.push({ x,y });
								count++;

							}

						}
					}


				}

				number++;
			}

			
		}
			
	}

	if (SwanLakeNum1 == SwanLakeNum2)
		return 0;

	while (!findQ.empty())
	{
		int x = findQ.front().first;
		int y = findQ.front().second;

		findQ.pop();


		for (int p = 0; p < 4; p++)
		{
			int nextX = x + dx[p];
			int nextY = y + dy[p];

			if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C)
			{
				if (boards[nextX][nextY].lakeNum == -2)
				{
					findQ.push({ nextX,nextY });
					boards[nextX][nextY].lakeNum = boards[x][y].lakeNum;
					boards[nextX][nextY].time = boards[x][y].time+1;

				}
				else if (boards[nextX][nextY].lakeNum != boards[x][y].lakeNum)
				{
					if (boards[nextX][nextY].time == boards[x][y].time + 1)
					{
						boards[nextX][nextY].time = boards[x][y].time + 1;

						unionParent(boards[nextX][nextY].lakeNum, boards[x][y].lakeNum);

						
					}
					else
					{
						unionParent(boards[nextX][nextY].lakeNum, boards[x][y].lakeNum);
					}

					// 위 과정을 통해 변경된 경우
					if (isSameParent(SwanLakeNum1, SwanLakeNum2))
					{
						return boards[nextX][nextY].time;
					}

				}

			}
		}
	}

	return 0;
}



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int R, C;
	string S;
	int value;
	vector<pair<int, int>> v;
	cin >> R >> C;
	for (int i = 0; i < R; i++)
	{
		cin >> S;
		boards.push_back({});
		for (int j = 0; j < C; j++)
		{
			if (S[j] == '.')
				value = -1;
			else if (S[j] == 'X')
				value = -2;
			else
			{
				v.push_back({ i,j });
				value = -1;
			}
			boards[i].push_back({ value,0 });
		}
	}


	cout << solution(R, C, v) << endl;

	

	return 0;
}