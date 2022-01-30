#include <bits/stdc++.h>
#include<unordered_map>
#include<unordered_set>
using namespace std;

unordered_map<int, vector<int>> um;
unordered_map<int, int> parentNum;
unordered_set<int> totalNum;

string findTree(int tc) {
	// 1. 루트 찾기

	int rootNode = -1;

	if (um.size() == 0) {
		return "Case " + to_string(tc) + " is a tree.";

	}

	for (auto node : totalNum) {
		if (parentNum.find(node) == parentNum.end()) {
			if (rootNode != -1) {
				return "Case " + to_string(tc) + " is not a tree.";
			}
			rootNode = node;
		}
		else if (parentNum[node] > 1) {
			return "Case " + to_string(tc) + " is not a tree.";

		}
	}

	if (rootNode == -1) {
		return "Case " + to_string(tc) + " is not a tree.";

	}

	unordered_map<int, int> visited;
	visited[rootNode]++;

	queue<int> q;

	q.push(rootNode);

	while (!q.empty()) {

		int nowNode = q.front();
		q.pop();

		for (auto next : um[nowNode]) {
			// 이미 도착한 경우
			if (visited.find(next) != visited.end()) {
				return "Case " + to_string(tc) + " is not a tree.";

			}
			q.push(next);
			visited[next]++;
		}

	}

	if (visited.size() != totalNum.size()) {
		return "Case " + to_string(tc) + " is not a tree.";

	}

	return "Case " + to_string(tc) + " is a tree.";

}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int tc = 1;
	int a, b;
	cin >> a >> b;

	while (a != -1 && b != -1) {

		if (a == 0 && b == 0) {
			//시작
			cout << findTree(tc) << "\n";

			um.clear();
			parentNum.clear();
			totalNum.clear();
			tc++;
		}
		else {
			um[a].push_back(b);
			parentNum[b]++;
			totalNum.insert(a);
			totalNum.insert(b);
		}
		cin >> a >> b;


	}


	return 0;
}