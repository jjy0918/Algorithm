// 알고리즘에 필요한 헤더 모음
// string은 따로 선언 필요
#include <bits/stdc++.h>
#include <string>

/*
    2차원에서 좌표 이동 간편하게
    상, 하, 좌, 우 움직일 때 사용.
    int dx{] = { 0,0,1,-1 };
    int dy[] = { 1,-1,0,0 };

    x,y => 현재 좌표, nx,ny => 이동 후 좌표

    for(int i=0;i<4;i++)
    {
        int nx=x+dx[i];
        int ny=y+dy[i];
        if(nx>=0 && ny >=0 && nx < N && ny < N)
        {
            내용
        }
    }
*/

// pair 간편 사용
// typedef pair<int, int> pii;

/*
    공간 복잡도 계산

    int 최대 값 2147483647(약 21억)
    21억 이상인 값은 long long 이용

    256mb 기준 int 6천만개 사용 가능.(int는 4바이트)
    => 저장할 데이터가 6천만개 이상인 경우 해쉬(unordered_map) 이용
    (ex. 2019 카카오 겨울 인턴 3번 문제에서 방을 모두 배열로 선언하면 10^12개가 필요하다.
     해시를 이용하면 해당 메모리 문제를 해결할 수 있다.)
*/

/*
    시간 복잡도 계산

    1초에 1억번 연산한다고 생각하면 쉽다.
    대부분 1초 안에 연산을 할 수 있어야 한다.

    N = 1억 : O(N), O(logN)
    N = 100만 : O(NlogN)
    N = 1만 : O(N^2)
    N = 20 : O(2^N)

*/

/*
    자료구조 선택
    일반적인 경우 : 배열, 벡터
    LIFO : stack
    FIFO : queue
    가장 큰 값, 가장 작은 값을 자주 탐색 : priority_queue
    정렬된 데이터가 자주 필요할 때 : set, map
    빠른 저장 및 탐색이 필요할 떄 : unordered_set, unordered_map
    문자열 탐색 : 트라이
    공통 조상 판별 시 : 유니온 파인드

*/

/*
    형 변환
    int -> string : to_string(Num);
    string -> int : stoi(string);
*/



using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	return 0;
}
