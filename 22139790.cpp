#include <iostream>
#include <vector>
#include <functional>
#include <queue>


using namespace std;


vector<pair<int,int>> v[502];
long long dist[502];

int main() 
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;

	int A, B, C;

	bool isCycle = false;

	

	cin >> N >> M;

	for (int i = 0; i < M; i++)
	{
		cin >> A >> B >> C;
		v[A].push_back({B,C });
	}

	fill_n(dist, 502, 987654321);

	dist[1] = 0;

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			for (auto edge : v[j])
			{
				if (dist[j] != 987654321 && dist[edge.first] > edge.second + dist[j])
				{
					dist[edge.first] = edge.second + dist[j];
					if (i == N)
						isCycle = true;
				}
			}
		}
	}

	if (isCycle)
		cout << "-1\n";
	else
	{
		for (int i = 2; i <= N; i++)
		{
			if (dist[i] == 987654321)
				cout << "-1\n";
			else
				cout << dist[i] << "\n";
		}
	}



	return 0;
}
