#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

int leftArr[1000001];
int rightArr[1000001];

void solution(vector<int>& array) {
	vector<int> answer;

	// 숫자, 인덱스
	stack<pair<int, int>> leftstack;
	stack<pair<int, int>> rightstack;

	for (int i = array.size() - 1; i >= 0; i--) {
		int num = array[i];
		rightArr[i] = -1;

		if (rightstack.empty()) {
			rightstack.push({ num,i });
		}
		else {
			while (!rightstack.empty()) {

				int nextNum = rightstack.top().first;
				int nextIndex = rightstack.top().second;

				if (nextNum <= num) {
					rightstack.pop();
				}
				else {
					rightArr[i] = nextIndex;
					break;
				}
			}

			rightstack.push({ num,i });
		}
	}


	for (int i = 0; i < array.size(); i++) {

		if (rightArr[i] == -1) {
			cout << -1 << " ";
		}
		else {
			cout << array[rightArr[i]] << " ";

		}


	}

}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		int c;
		cin >> c;
		v.push_back(c);
	}

	solution(v);


	return 0;
}
