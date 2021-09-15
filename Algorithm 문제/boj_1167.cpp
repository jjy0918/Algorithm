#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;
vector<pair<int, int>> v[100001];

long long dist[100001];

bool visited[100001];

int V;

int nowindex = 1;

long long di() {
	long long result = 0;

	fill_n(dist, 100001, LLONG_MAX);
	fill_n(visited, 100001, false);

	dist[nowindex] = 0;

	priority_queue<pair<int, int>> pq;

	pq.push({ 0,nowindex });


	while (!pq.empty()) {

		pair<int, int> p = pq.top();
		pq.pop();


		if (visited[p.second]) {
			continue;
		}

		visited[p.second] = true;

		for (auto np : v[p.second]) {

			if (visited[np.first]) {
				continue;
			}

			if (dist[np.first] > -p.first + np.second) {
				dist[np.first] = -p.first + np.second;

				pq.push({ -dist[np.first] ,np.first });
			}


		}

	}

	for (int i = 1; i <= V; i++) {

		if (dist[i] == LLONG_MAX) {
			continue;
		}

		if (result < dist[i]) {
			result = dist[i];
			nowindex = i;
		}
	}

	return result;

}

int main()
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);



	int startNum = 0;

	cin >> V;


	for (int i = 0; i < V; i++) {
		int s;
		int e, d;
		cin >> s;
		cin >> e;
		while (e != -1) {
			cin >> d;
			v[s].push_back({ e,d });
			cin >> e;
		}
	}

	long long result = 0;
	nowindex = 1;

	while (true) {

		long long now = di();
		if (result >= now) {
			break;
		}
		result = now;

	}

	cout << result << endl;



	return 0;
}