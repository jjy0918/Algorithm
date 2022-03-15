#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <vector>
#include <algorithm>
#include <string>
#include <functional>
#include <stack>
#include <cstdio>   // printf , scanf 이용 훨씬 더 빠르다.
#include <sstream>

using namespace std;

vector<vector<int>> pground;
vector<vector<int>> ground;
vector<vector<pair<int, int>>> visit;

const int iMax = 2147483647;


typedef struct {
	int nowX, nowY;
	bool plusPast;
	int time;
}path;


int N, M;


void pathFilter()
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (pground[i][j] == 0)
			{
				if (((i > 0 && pground[i - 1][j] == 0) || (i < N - 1 && pground[i + 1][j] == 0))
					&& ((j > 0 && pground[i][j - 1] == 0) || (j < N - 1 && pground[i][j + 1] == 0)))
				{
					ground[i][j] = -1;
				}
			}

		}
	}


}


void newfindPath()
{
	queue<path> bfsQ;
	path p;
	bfsQ.push({ 0,0,false,0 });
	int nowX, nowY;
	bool plusPast;
	int time;

	while (!bfsQ.empty())
	{

		p = bfsQ.front();
		bfsQ.pop();
		nowX = p.nowX;
		nowY = p.nowY;
		plusPast = p.plusPast;  // 오작교 새로 사용 여부
		time = p.time;

		if (plusPast)
		{
			if (visit[nowX][nowY].first >= time)
			{
				visit[nowX][nowY].first = time;
			}
			else
				continue;
		}
		else
		{
			if (visit[nowX][nowY].second >= time)
			{
				visit[nowX][nowY].second = time;
			}
			else
				continue;
		}


		time++;

		// 아래로
		if (nowX < N - 1)
		{
			if (ground[nowX][nowY] == 1)
			{

				if (ground[nowX + 1][nowY] == 1)
				{

					bfsQ.push({ nowX + 1,nowY,plusPast,time });
				}
				else if (ground[nowX + 1][nowY] > 1)
				{

					if (time%ground[nowX + 1][nowY] == 0)
					{
						bfsQ.push({ nowX + 1,nowY,plusPast,time });
					}
					else
					{
						bfsQ.push({ nowX + 1,nowY,plusPast,time + ground[nowX + 1][nowY] - time%ground[nowX + 1][nowY] });
					}
				}
				else if (ground[nowX + 1][nowY] == 0 && !plusPast)
				{

					if (time%M == 0)
					{
						bfsQ.push({ nowX + 1,nowY,true,time });
					}
					else
					{
						bfsQ.push({ nowX + 1,nowY,true,time + M - time%M });
					}
				}

			}
			else if (ground[nowX][nowY] != -1)
			{

				if (ground[nowX + 1][nowY] == 1)
				{
					bfsQ.push({ nowX + 1,nowY,plusPast,time });
				}
			}


		}

		// 오른쪽으로
		if (nowY < N - 1)
		{

			if (ground[nowX][nowY] == 1)
			{
				if (ground[nowX][nowY + 1] == 1)
				{
					bfsQ.push({ nowX,nowY + 1,plusPast,time });

				}

				else if (ground[nowX][nowY + 1] > 1)
				{
					if (time%ground[nowX][nowY + 1] == 0)
					{
						bfsQ.push({ nowX,nowY + 1,plusPast,time });

					}
					else
					{
						bfsQ.push({ nowX,nowY + 1 ,plusPast,time + ground[nowX][nowY + 1] - time%ground[nowX][nowY + 1] });

					}
				}
				else if (ground[nowX][nowY + 1] == 0 && !plusPast)
				{
					if (time%M == 0)
					{
						bfsQ.push({ nowX,nowY + 1,true,time });

					}
					else
					{
						bfsQ.push({ nowX,nowY + 1,true,time + M - time%M });
					}
				}

			}
			else if (ground[nowX][nowY] != -1)
			{
				if (ground[nowX][nowY + 1] == 1)
				{
					bfsQ.push({ nowX,nowY + 1,plusPast,time });

				}
			}

		}

		// 위로
		if (nowX > 0)
		{

			if (ground[nowX][nowY] == 1)
			{
				if (ground[nowX - 1][nowY] == 1)
				{
					bfsQ.push({ nowX - 1,nowY,plusPast,time });
				}
				else if (ground[nowX - 1][nowY] > 1)
				{
					if (time%ground[nowX - 1][nowY] == 0)
					{
						bfsQ.push({ nowX - 1,nowY,plusPast,time });
					}
					else
					{
						bfsQ.push({ nowX - 1,nowY,plusPast,time + ground[nowX - 1][nowY] - time%ground[nowX - 1][nowY] });
					}
				}
				else if (ground[nowX - 1][nowY] == 0 && !plusPast)
				{
					if (time%M == 0)
					{
						bfsQ.push({ nowX - 1,nowY,true,time });
					}
					else
					{
						bfsQ.push({ nowX - 1,nowY,true,time + M - time%M });
					}
				}

			}
			else if (ground[nowX][nowY] != -1)
			{
				if (ground[nowX - 1][nowY] == 1)
				{
					bfsQ.push({ nowX - 1,nowY,plusPast,time });
				}
			}


		}


		// 왼쪽으로
		if (nowY > 0)
		{

			if (ground[nowX][nowY] == 1)
			{
				if (ground[nowX][nowY - 1] == 1)
				{
					bfsQ.push({ nowX,nowY - 1,plusPast,time });

				}

				else if (ground[nowX][nowY - 1] > 1)
				{
					if (time%ground[nowX][nowY - 1] == 0)
					{
						bfsQ.push({ nowX,nowY - 1,plusPast,time });

					}
					else
					{
						bfsQ.push({ nowX,nowY - 1 ,plusPast,time + ground[nowX][nowY - 1] + time%ground[nowX][nowY - 1] });

					}
				}
				else if (ground[nowX][nowY - 1] == 0 && !plusPast)
				{
					if (time%M == 0)
					{
						bfsQ.push({ nowX,nowY - 1,true,time });

					}
					else
					{
						bfsQ.push({ nowX,nowY - 1,true,time + M - time%M });
					}
				}

			}
			else if (ground[nowX][nowY] != -1)
			{
				if (ground[nowX][nowY - 1] == 1)
				{
					bfsQ.push({ nowX,nowY - 1,plusPast,time });

				}
			}
		}


	}

}


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	int tmp;

	cin >> N >> M;


	for (int n1 = 0; n1 < N; n1++)
	{
		pground.push_back(vector<int>());
		ground.push_back(vector<int>());
		visit.push_back(vector < pair<int, int>>());

		for (int n2 = 0; n2 < N; n2++)
		{
			cin >> tmp;
			pground[n1].push_back(tmp);
			ground[n1].push_back(tmp);
			visit[n1].push_back(make_pair(iMax, iMax));
		}
	}


	pathFilter();

	newfindPath();


	cout << min(visit[N - 1][N - 1].first, visit[N - 1][N - 1].second) << endl;

	return 0;
}