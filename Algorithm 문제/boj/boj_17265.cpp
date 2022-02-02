#include <bits/stdc++.h>

using namespace std;

char boards[6][6];
int visited[2][6][6];

int N;

char oper[]{ '+' - '0' ,'*' - '0','-' - '0' };

int dy[]{ 0,1 };
int dx[]{ 1,0 };


int calc(char op, int n1, int n2) {

	if (op == oper[0]) {
		return n1 + n2;
	}
	else if (op == oper[1]) {
		return n1 * n2;
	}
	else if (op == oper[2]) {
		return n1 - n2;

	}
	return n2;

}

void DFS(int y, int x, int cnt, char op) {

	if (y < 0 || x < 0 || y >= N || x >= N) {
		return;
	}

	char nowChar = boards[y][x] - '0';

	// 연산자를 만난 경우
	for (int i = 0; i < 3; i++) {
		if (nowChar == oper[i]) {
			DFS(y + dy[0], x + dx[0], cnt, nowChar);
			DFS(y + dy[1], x + dx[1], cnt, nowChar);
			return;
		}
	}
	int resultCalc = calc(op, cnt, nowChar);
	if (resultCalc > visited[0][y][x]) {
		visited[0][y][x] = resultCalc;
		DFS(y + dy[0], x + dx[0], resultCalc, op);
		DFS(y + dy[1], x + dx[1], resultCalc, op);
	}
	if (resultCalc < visited[1][y][x]) {
		visited[1][y][x] = resultCalc;
		DFS(y + dy[0], x + dx[0], resultCalc, op);
		DFS(y + dy[1], x + dx[1], resultCalc, op);
	}


}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			char c;
			cin >> c;
			boards[i][j] = c;
			visited[0][i][j] = INT_MIN;
			visited[1][i][j] = INT_MAX;
		}
	}
	DFS(0, 0, 0, 0);

	cout << visited[0][N - 1][N - 1] << " " << visited[1][N - 1][N - 1] << endl;



	return 0;
}