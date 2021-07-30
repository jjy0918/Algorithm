	/*
	
	백준 10282 문제 - 해킹
	https://www.acmicpc.net/problem/10282
	https://9327144.tistory.com/entry/BOJ-10282-%ED%95%B4%ED%82%B9

	*/
#include <bits/stdc++.h>
#include<unordered_map>
using namespace std;

int n, d, c;
int a, b, s;

int visited[10001];

pair<int, int> Dijkstra(int start, vector<vector<pair<int, int>>> &v) {

	priority_queue<pair<int, int>> pq;


	fill_n(visited, 10001, INT_MAX);

	visited[start] = 0;

	pq.push({ 0,start });

	while (!pq.empty()) {
		int startNode = pq.top().second;
		int startCost = -pq.top().first;
		pq.pop();

		if (visited[startNode] > startCost) {
			continue;
		}

		for (auto next : v[startNode]) {
			int nextNode = next.first;
			int nextCost = next.second;


			if (visited[nextNode] <= startCost + nextCost) {
				continue;
			}
			visited[nextNode] = startCost + nextCost;

			pq.push({ -visited[nextNode],nextNode });


		}

	}

	int maxLength = 0;
	int cnt = 0;

	for (int i = 1; i <= n; i++) {
		if (visited[i] == INT_MAX) {
			continue;
		}
		maxLength = max(maxLength, visited[i]);
		cnt++;
	}

	return{ cnt,maxLength };
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t;
	cin >> t;


	while (t--) {
		cin >> n >> d >> c;
		vector<vector<pair<int, int>>> v(n + 1);

		for (int i = 0; i < d; i++) {
			cin >> a >> b >> s;
			v[b].push_back({ a,s });
		}

		pair<int, int> result = Dijkstra(c, v);

		cout << result.first << " " << result.second << "\n";


	}


	return 0;
}