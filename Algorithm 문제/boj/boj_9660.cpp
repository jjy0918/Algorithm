#include <bits/stdc++.h>
#include <unordered_set>
#include <unordered_map>
using namespace std;


bool isSK[1001];


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long N;
	cin >> N;

	isSK[1] = true;
	isSK[2] = false;
	isSK[3] = true;
	isSK[4] = true;

	isSK[5] = true;
	isSK[6] = true;
	isSK[7] = false;

	N = (N % 7);

	if (isSK[N]) {
		cout << "SK\n";

	}
	else {
		cout << "CY\n";
	}

	return 0;
}