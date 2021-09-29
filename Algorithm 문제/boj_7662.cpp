#include <bits/stdc++.h>
#include <cstdlib>
#include<unordered_map>
#include<unordered_set>
using namespace std;

multiset<int> ms;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int tc,t;

	cin >> tc;

	for (int i = 0; i < tc; i++) {

		ms.clear();

		cin >> t;

		char oper;
		int n;

		for (int j = 0; j < t; j++) {
			cin >> oper >> n;

			if (oper == 'I') {
				ms.insert(n);
			}
			else {
				if (ms.empty()) {
					continue;
				}

				if (n == 1) {
					int val = *ms.rbegin();
					int cnt = ms.count(val);
					ms.erase(*ms.rbegin());

					if (cnt > 1) {
						for (int i = 1; i < cnt; i++) {
							ms.insert(val);

						}
					}

				}
				else {
					ms.erase(ms.begin());

				}


			}

		}

		if (ms.empty()) {
			cout << "EMPTY\n";
		}
		else {
			cout << *ms.rbegin() << " " << *ms.begin() << "\n";
		}
		

	}


	return 0;
}