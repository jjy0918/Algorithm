	/*
	
	백준 6549 문제 - 유기농 배추
	https://www.acmicpc.net/problem/6549
	https://9327144.tistory.com/entry/BOJ-6549-%ED%9E%88%EC%8A%A4%ED%86%A0%EA%B7%B8%EB%9E%A8%EC%97%90%EC%84%9C-%EA%B0%80%EC%9E%A5-%ED%81%B0-%EC%A7%81%EC%82%AC%EA%B0%81%ED%98%95-C

	*/
#include <bits/stdc++.h>
#include<unordered_map>
using namespace std;

long long rec(int start, int last, vector<int> &v) {

	if (start == last) {
		return v[start];
	}

	long long result = 0;
	int mid = (start + last) / 2;

	int left = mid;
	int right = mid + 1;
	long long height = min(v[left], v[right]);
	result = height * 2;

	while (start < left || right < last) {
		long long now = 0;
		// 왼쪽 끝
		if (left == start) {
			right++;
			now = v[right];

		}
		// 오른쪽 끝
		else if (right == last) {
			left--;
			now = v[left];
		}
		// 다음 선택할 인덱스의 값 중 큰 값으로 이동한다.
		else if (v[left - 1] > v[right + 1]) {
			left--;
			now = v[left];

		}
		else {
			right++;
			now = v[right];
		}

		height = min(height, now);
		result = max(result, height*(right - left + 1));

	}

	result = max(result, rec(start, mid, v));
	result = max(result, rec(mid + 1, last, v));

	return result;


}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, H;

	cin >> N;

	while (N != 0) {
		vector<int>v;
		for (int i = 0; i < N; i++) {
			cin >> H;
			v.push_back(H);
		}
		cout << rec(0, N - 1, v) << endl;
		cin >> N;
	}



	return 0;
}