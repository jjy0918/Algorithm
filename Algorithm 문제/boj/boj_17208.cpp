#include <bits/stdc++.h>
#include <unordered_set>
#include <unordered_map>
using namespace std;



int D[101][301][301];
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M, K;
	int x, y;
	int result1 = 0;
	int result2 = 0;

	cin >> N >> M >> K;

	for (int i = 1; i <= N; i++) {
		cin >> x >> y;

		for (int j = 0; j < 301; j++) {

			for (int k = 0; k < 301; k++) {
				D[i][j][k] = D[i - 1][j][k];

				if (j - x >= 0 && k - y >= 0) {
					D[i][j][k] = max(D[i][j][k], D[i - 1][j - x][k - y] + 1);
				}



			}

		}

	}
	cout << D[N][M][K] << endl;

	return 0;
}