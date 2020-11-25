// 다익스트라 

vector<int> dijkstra(vector<vector<pair<int, int>>> &g,int start)
{
	priority_queue<pair<int, int>> pq;
	vector<int> dist(6,INT_MAX);
	dist[start] = 0;
    
   	bool visit[6]={0,};
    	visit[start]=true;

	pq.push(make_pair(0, start));

	while (!pq.empty())
	{
		int nowCost = -pq.top().first;
		int nowNode = pq.top().second;
        	visit[nowNode] = true;
		pq.pop();

		for (auto nextPair : g[nowNode])
		{
        	
			int nextNode = nextPair.first;
			int nextCost = nextPair.second;
            
                        if(visit[nextNode])
                            continue;
            
            
			if (dist[nextNode] > dist[nowNode] + nextCost)
			{
				dist[nextNode] = dist[nowNode] + nextCost;

				// 우선순위큐는 기본 값이 maxHeap이기 때문에 거리값의 
				// 절대값이 작은 수 부터 탐색하기 위해 -를 붙인다.
				pq.push(make_pair(-dist[nextNode], nextNode));
			}
		}
	}

	return dist;
}

// 벨만 포드

void bellman_ford(vector<vector<pair<int, int>>> edge, int start)
{
	vector<int> distance(edge.size(), INT_MAX);

	distance[start] = 0;

	for (int n = 0; n < edge.size() - 1; n++)
	{
		for (int i = 0; i < edge.size(); i++)
		{
			for (int j = 0; j < edge[i].size(); j++)
			{
				// 정점 i 에서 v 까지의 가중치 cost
				int v = edge[i][j].first;
				int cost = edge[i][j].second;

				// distance[i]의 값이 무한대인 경우는 판단하지 않는다.
				if (distance[i] != INT_MAX && distance[v] > distance[i] + cost)
				{
					distance[v] = distance[i] + cost;
				}
			}
		}
	}

	for (int i = 0; i < edge.size(); i++)
	{
		for (int j = 0; j < edge[i].size(); j++)
		{
			int v = edge[i][j].first;
			int cost = edge[i][j].second;

			// 거리 값이 변경되는 경우 음의 사이클이 발생한 것이다.
			if (distance[i] != INT_MAX && distance[v] > distance[i] + cost)
			{
				cout << "음의 사이클 발생\n";
				return;
			}
		}
	}

	for (int i = 0; i < distance.size(); i++)
	{
		cout << start << " 에서 " << i << " 까지의 최단 거리 : " << distance[i] << endl;
	}

}
