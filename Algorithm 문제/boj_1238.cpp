#include <bits/stdc++.h>

using namespace std;

int N, M, X;

vector<pair<int,int>> road[1001];
vector<pair<int, int>> roadReverse[1001];

int visited[1001];
int visitedReverse[1001];


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	fill_n(visited, 1001, INT_MAX);
	fill_n(visitedReverse, 1001, INT_MAX);

	cin >> N >> M >> X;

	for (int i = 0; i < M; i++) {

		int s, e, t;
		cin >> s >> e >> t;
		road[s].push_back({ e,t });
		roadReverse[e].push_back({ s,t });

	}

	visited[X] = 0;
	priority_queue<pair<int, int>> pq;
	pq.push({ 0,X });

	while (!pq.empty()) {
		
		int nowNode = pq.top().second;
		int nowCost = -pq.top().first;
		pq.pop();

		for (auto next : road[nowNode]) {

			int nextNode = next.first;
			int nextCost = next.second;

			if (visited[nextNode] > nowCost + nextCost) {
				visited[nextNode] = nowCost + nextCost;
				pq.push({ -visited[nextNode],nextNode });
			}

		}

	}

	visitedReverse[X] = 0;
	pq.push({ 0,X });

	while (!pq.empty()) {

		int nowNode = pq.top().second;
		int nowCost = -pq.top().first;
		pq.pop();


		for (auto next : roadReverse[nowNode]) {

			int nextNode = next.first;
			int nextCost = next.second;

			if (visitedReverse[nextNode] > nowCost + nextCost) {
				visitedReverse[nextNode] = nowCost + nextCost;
				pq.push({ -visitedReverse[nextNode],nextNode });
			}

		}

	}

	int result = 0;
	for (int i = 1; i <= N; i++) {
		int sum = visited[i] + visitedReverse[i];
		result = max(result, sum);
	}

	cout << result << endl;


	return 0;
}