#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

// boj 	11437 LCA

int height[50001];
int myParent[50001];
bool isVisit[50001];


vector<int> v[50001];

void findParent(int root, int h) {
	if (v[root].size() == 0)
	{
		return;
	}

	for (int child : v[root]) {
		if (isVisit[child])
			continue;

		height[child] = h;
		isVisit[child] = true;
		myParent[child] = root;
		findParent(child, h + 1);
	}

	return;
}


int child(int root, int h) {
	if (h == height[root]) {
		return root;
	}

	return child(myParent[root], h);
}

int findSameRoot(int n1, int n2) {
	if (n1 == n2) {
		return n1;
	}

	return findSameRoot(myParent[n1], myParent[n2]);
}


int main()
{

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N;

	int a, b;

	vector<int> result;

	for (int i = 0; i < N - 1; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
		myParent[b] = a;
	}
	isVisit[1] = true;

	// 자기 자신 부모 찾기 및 높이 저장
	findParent(1, 1);


	cin >> M;

	for (int i = 0; i < M; i++) {
		cin >> a >> b;

		// 높이 받아오기
		int h1 = height[a];
		int h2 = height[b];

		// 높이가 다른 경우 같은 높이까지 올려준다.
		if (h1 > h2) {
			a = child(a, h2);
		}
		else if (h1 < h2) {
			b = child(b, h1);
		}

		// 높이가 같은 경우 높이를 하나씩 올려가며 공통 조상 찾기
		// 공통 조상의 경우 높이가 반드시 같다.
		cout << findSameRoot(a, b) << endl;

	}

	return 0;
}
