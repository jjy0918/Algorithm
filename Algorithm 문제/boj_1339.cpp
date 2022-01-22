#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<string> v;

	// 각 문자의 가중치를 부여하여 저장
	unordered_map<char, int>um;

	int N;
	cin >> N;
	
	// 처음 문자열 저장
	vector<string> vs;
	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < s.size(); j++) {
			um[s[j]] += pow(10, s.size()-j);
		}
		v.push_back(s);
	}

	// 가중치 기준으로 내림차순 정렬
	vector<pair<int, char>> vm;
	for (auto iter = um.begin(); iter != um.end(); iter++) {
		vm.push_back({ iter->second ,iter->first });
	}

	sort(vm.begin(), vm.end());
	reverse(vm.begin(), vm.end());


	// 가중치 순으로 9~0 문자마다 값 부여
	unordered_map<char, int> resultChar;

	int n = 9;
	for (auto a : vm) {
		resultChar[a.second] = n;
		n--;
	}

	// 문자에 맞는 값 찾아서 숫자로 변환
	int result = 0;
	for (auto a : v) {
		for (int i = 0; i < a.size(); i++) {
			result += resultChar[a[i]] * pow(10, a.size() - 1 - i);
		}
	}

	cout << result << endl;



	return 0;
}

