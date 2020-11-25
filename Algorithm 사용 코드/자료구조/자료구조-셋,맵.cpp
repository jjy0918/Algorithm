// 헤더 선언 필요
#include <set>

// int 자료형을 저장하는 셋 선언
set<int> s;

// 원소 n 추가
s.insert(n);

// 원소 n 찾기, 해당 원소가 존재하면 해당 주소 반환, 없으면 s.end() 반환.
s.find(n);

// 값이 n인 원소 제거
s.erase(n);

// 모든 원소 제거
s.clear();

// set의 크기(원소의 개수) 반환
s.size();

// 셋 탐색
for(auto n : s)
    cout<<n<<endl;

// 맵

// 헤더 선언 필요
#include <map>

// int, string 자료형을 저장하는 맵 선언
map<int, string> m;

// 원소 추가(insert)
m.insert(1, "test1");

// 원소 추가(인덱스)
// 해당 키 값이 존재하지 않으면 원소가 추가되고, 존재하면 값이 수정된다.
m[2] = "test2";

// 원소 찾기
// 해당 key가 존재하면 iterator 반환. 없으면 m.end() 반환.
m.find(key);

auto mf = m.find(3);
cout << mf->first << " : " << mf->second << endl;

// key에 해당하는 원소 제거
m.erase(key);

// 모든 원소 제거
m.clear();

// 저장된 원소 개수 출력
m.size();

// unordered_set, unordered_map
// 헤더 선언 필요
#include<unordered_set>
#include<unordered_map>

// 사용 방법은 set, map과 동일하다
unordered_set<int> us;
unordered_map<int, int> um;