class Solution {

    boolean isNotPrime[];

    boolean visited[];

    int answer = 0;
    void checkPrime(){
        isNotPrime = new boolean[10000000];
        visited = new boolean[10000000];

        isNotPrime[1]=true;
        isNotPrime[0]=true;

        for(int i=2;i<10000000;i++){
            if(isNotPrime[i]){
                continue;
            }
            int num = i+i;
            while(num<10000000){
                isNotPrime[num]=true;
                num+=i;
            }

        }

    }

    public int solution(String numbers) {

        checkPrime();

        dfs(numbers,0,new boolean[numbers.length()],new StringBuilder());

        return answer;
    }

    void dfs(String numbers, int cnt, boolean selected[],StringBuilder sb){
        if(cnt==numbers.length()){

            if(sb.length()==0){
                return;
            }

            int num = Integer.parseInt(sb.toString());

            if(!visited[num] && !isNotPrime[num]){
                visited[num]=true;
                answer++;
            }

            return ;
        }

        dfs(numbers,cnt+1,selected,sb);

        for(int i=0;i<numbers.length();i++){

            if(selected[i]){
                continue;
            }

            selected[i]=true;
            sb.append(numbers.charAt(i));

            dfs(numbers,cnt+1,selected,sb);

            sb.setLength(sb.length()-1);
            selected[i]=false;

        }

        // 해당 인덱스 선택하지 않는 경우

    }

}