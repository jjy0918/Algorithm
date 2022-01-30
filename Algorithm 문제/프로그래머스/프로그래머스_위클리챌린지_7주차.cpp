#include <bits/stdc++.h>
#include <cstdlib>
#include<unordered_map>
#include<unordered_set>
using namespace std;

unordered_set<int> us;

vector<int> solution(vector<int> enter, vector<int> leave) {
	vector<int> answer(enter.size());
	int enterIndex = 0;

	us.insert(enter[enterIndex]);
	enterIndex++;

	for (int i = 0; i < leave.size(); i++) {
		// 나가는 애들이 있다면
		if (us.find(leave[i]) != us.end()) {
			us.erase(leave[i]);
			continue;
		}
		for (; enterIndex < enter.size(); enterIndex++) {

			for (auto remain : us) {
				answer[remain - 1]++;

			}
			answer[enter[enterIndex] - 1] = us.size();

			us.insert(enter[enterIndex]);

			if (enter[enterIndex] == leave[i]) {
				enterIndex++;
				break;
			}
		}
		i--;
	}
	return answer;
}
