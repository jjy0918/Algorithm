#include <bits/stdc++.h>
#include <cstdlib>
#include<unordered_map>
#include<unordered_set>
using namespace std;

const int HOLE = 'H' - '0';

int boards[50][50];

int visited[50][50];

bool visitedCycle[50][50];

bool isNotCycle[50][50];

int Y, X;

int dy[]{ 0,0,1,-1 };
int dx[]{ 1,-1,0,0 };

// 사이클이 있는지 먼저 체크
// isNotCycle로 이미 사이클이 존재하지 않는 것을 저장
// checkCycle은 현재 순회중인 부분을 이미 방문했는지 저장
bool checkCycle(int y,int x) {
	if (isNotCycle[y][x]) {
		return false;
	}

	bool result = false;

	for (int d = 0; d < 4; d++) {
		int ny = y + dy[d] * boards[y][x];
		int nx = x + dx[d] * boards[y][x];

		if (ny < 0 || nx < 0 || ny >= Y || nx >= X || boards[ny][nx] == HOLE) {
			continue;
		}

		if (visitedCycle[ny][nx]) {
			return true;
		}

		visitedCycle[ny][nx] = true;
		
		if (checkCycle(ny, nx)) {
			return true;
		}

		isNotCycle[ny][nx] = true;

		visitedCycle[ny][nx] = false;

	}
	isNotCycle[y][x] = true;
	return false;

}

// dfs돌면서 현재 위치에서 갈 수 있는 최대 횟수를 저장해서
// 이미 방문했던 위치이면 다시 계산하지 않도록 한다.
int dfs(int y, int x) {

	if (visited[y][x] != INT_MAX) {
		return visited[y][x];
	}

	int result = 1;

	for (int d = 0; d < 4; d++) {
		int ny = y + dy[d]*boards[y][x];
		int nx = x + dx[d] * boards[y][x];

		if (ny < 0 || nx < 0 || ny >= Y || nx >= X || boards[ny][nx]== HOLE) {
			continue;
		}
		
		result = max(result, dfs(ny,nx)+1);
		
	}

	return visited[y][x] = result;

}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> Y >> X;

	for (int i = 0; i < Y; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < X; j++) {
			boards[i][j] = s[j] - '0';
		}
	}

	if (checkCycle(0, 0)) {
		cout << -1 << endl;
	}
	else {
		
		fill(&visited[0][0], &visited[0][0] + 50 * 50, INT_MAX);

		cout << dfs(0, 0) << endl;
	}
	
	return 0;
}