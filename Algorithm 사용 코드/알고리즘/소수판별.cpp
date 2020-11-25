// 에라토스테네스의 체

void prim(int n)
{
	vector<bool> isNotPrime(n + 1,0);

	if (n <= 1)
		return;

	for (int i = 2; i <= n; i++)
	{
		// isNotPrime[i] = true => 숫자 i 는 소수가 아니다.
		if (isNotPrime[i])
			continue;

		for (int j = 2 * i; j <= n; j += i)
			isNotPrime[j] = 1;

		// 소수인 경우 처리할 문장
		cout <<"소수 발견 : "<< i << endl;
	}
}