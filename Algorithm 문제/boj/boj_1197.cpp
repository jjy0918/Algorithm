#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;


struct cmp {
	bool operator()(pair< int, int>p1, pair< int, int> p2) {
		if (p1.second > p2.second) {
			return true;
		}

		return false;
	}
};


int main()
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int V, E;
	int A, B, C;

	cin >> V >> E;

	// 정점, 가중치
	vector<vector<pair<int, int>>> v(V);
	vector<bool> visited(V, false);


	for (int i = 0; i < E; i++) {
		cin >> A >> B >> C;

		v[A - 1].push_back({ B - 1, C });
		v[B - 1].push_back({ A - 1, C });
	}
	int sum = 0;

	priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
	pq.push({ 0,0 });

	while (!pq.empty()) {

		pair<int, int> p = pq.top();
		pq.pop();

		if (visited[p.first]) {
			continue;
		}

		visited[p.first] = true;
		sum += p.second;

		for (auto np : v[p.first]) {
			if (visited[np.first]) {
				continue;
			}

			pq.push({ np.first,np.second });
		}

	}

	cout << sum << endl;


	return 0;
}




/*
c++ 난수 생성
srand((unsigned int)time(0));

0~99 난수
int r1 = rand() % 100;

*/
