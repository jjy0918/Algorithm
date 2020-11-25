// 크루스칼 알고리즘

// edges 벡터는 <가중치, <정점1, 정점2 >> 
// nodeN은 노드의 개수
void kruskal(vector<pair<int, pair<int, int>>> edges,int nodeN)
{

	int sumWeight = 0;

	// 유니온 파인드 초기화
	initUnion(nodeN);

	sort(edges.begin(), edges.end());

	for (auto e : edges)
	{
		// 같은 부모를 가지고 있는가 => 두 정점이 연결되어 있는가
		// 두 정점이 연결되어 있지 않는 경우
		if (!isSameParent(e.second.first, e.second.second))
		{
			sumWeight += e.first;

			// 두 정점의 부모를 같게 설정 => 두 정점을 연결
			unionParent(e.second.first, e.second.second);

			cout << e.second.first+1 << " , " 
            		<< e.second.second+1 << "연결 " << endl;

		}
	}

	cout << "신장 트리 최소 연결 비용 : " << sumWeight << endl;

}

// 프림 알고리즘
void prim(vector<vector<pair<int, int>>> v,int start)
{
	// 가중치, 정점
	priority_queue<pair<int, int>> pq;
	int sumWeight = 0;

	vector<bool> isVisit(v.size(), false);
	isVisit[start] = true;

	cout << start+1 << " 추가 " << endl;

	for (int i = 0; i < v[start].size(); i++)
	{
		pq.push({ -v[start][i].second,v[start][i].first });
	}

	while (!pq.empty())
	{
		int nowCost = pq.top().first;
		int nowNode = pq.top().second;
		pq.pop();
		if (isVisit[nowNode])
			continue;

		isVisit[nowNode] = true;
		sumWeight += -nowCost;

		cout << nowNode+1 << " 추가 " << endl;

		for (auto next : v[nowNode])
		{
			int nextCost = next.second;
			int nextNode = next.first;

			if (!isVisit[nextNode])
			{
				pq.push({ -nextCost,nextNode });
			}
		}
	}

	cout << " 최소 비용 : " << sumWeight << endl;
	
}