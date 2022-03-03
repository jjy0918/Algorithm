
#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

int maxSize = 100001;

int visited[100001];

void solution(int N, int K) {
	queue<pair<int, int>> q;
	q.push({ K,0 });
	fill_n(visited, 100001, INT_MAX);
	int result = 0;
	int resultTime = INT_MAX;
	visited[K] = 0;

	while (!q.empty())
	{
		int nowNode = q.front().first;
		int nowTime = q.front().second;
		q.pop();

		if (resultTime < nowTime)
			break;

		if (nowNode == N) {
			result++;
			resultTime = nowTime;

		}

		int nextNode;
		nextNode = nowNode + 1;
		if (nextNode >= 0 && nextNode < maxSize && visited[nextNode] >= nowTime + 1)
		{
			q.push({ nextNode,nowTime + 1 });
			visited[nextNode] = nowTime + 1;
		}

		nextNode = nowNode - 1;
		if (nextNode >= 0 && nextNode < maxSize && visited[nextNode] >= nowTime + 1)
		{
			q.push({ nextNode,nowTime + 1 });
			visited[nextNode] = nowTime + 1;
		}

		if (nowNode % 2 == 0) {
			nextNode = nowNode / 2;
			if (nextNode >= 0 && nextNode < maxSize && visited[nextNode] >= nowTime + 1)
			{
				q.push({ nextNode,nowTime + 1 });
				visited[nextNode] = nowTime + 1;
			}
		}


	}

	cout << resultTime << endl;
	cout << result << endl;
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K;
	cin >> N >> K;

	solution(N, K);

	return 0;
}

