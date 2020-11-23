// 유니온 파인드 클래스
class unionFind {
public:
    /*
        사용 방법
        unionFind uf;
        uf.initUnion(10); => 모든 노드 수 입력 후 초기화
        uf.unionParent(1, 2) => 1, 2 부모 합치기
        uf.findParent(1) => 1의 부모 찾기(자기 자신인 경우, 자신이 루트 노드인 경우)
        uf.isSameParent(1,2) => 1과 2의 부모가 같은지 확인
    */
	void initUnion(int n)
	{
		// 부모 노드에 자기 자신이 들어가 있는 경우(아무것도 연결되어 있지 않다.)
		for (int i = 0; i < n; i++)
		{
			parent.push_back(i);
			height.push_back(1);
		}

	}

	int findParent(int node)
	{
		// 노드의 부모가 자기 자신인 경우(최상위 노드, 부모노드)
		if (node == parent[node])
			return node;

		// 노드의 부모를 찾아서 대입한다.
		parent[node] = findParent(parent[node]);

		return parent[node];
	}

	// 노드 두 개 합치기(node1에 node2 붙이기)
	void unionParent(int node1, int node2)
	{
		// node1, node2의 부모 찾기
		node1 = findParent(node1);
		node2 = findParent(node2);

		// 두 노드의 부모 노드가 같다면 아무런 일도 일어나지 않는다.
		if (node1 == node2)
			return;
		// 두 노드의 높이를 비교하여 높이가 큰 노드에 높이가 작은 노드를 연결한다.
		else
		{
			if (height[node1] == height[node2])
			{
				height[node1]++;
				parent[node2] = node1;
			}
			else if (height[node1] > height[node2])
			{
				parent[node2] = node1;
			}
			else
			{
				parent[node1] = node2;
			}
		}

	}

	bool isSameParent(int node1, int node2)
	{
		node1 = findParent(node1);
		node2 = findParent(node2);

		if (node1 == node2)
			return true;
		else
			return false;
	}

private:
	vector<int> parent;

	vector<int> height;

};