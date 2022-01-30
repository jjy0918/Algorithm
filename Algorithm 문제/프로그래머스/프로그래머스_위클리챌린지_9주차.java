import java.util.*;
class Solution {
     // 1. 각 간선 끊기
        // 2. bfs 돌면서 몇개인지 체크
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            
            ArrayList<Node> arr[] = new ArrayList[n+1];
            for(int i=0;i<n+1;i++){
                arr[i]=new ArrayList<>();
            }
            
            for(int i=0;i<n-1;i++){
                arr[wires[i][0]].add(new Node(wires[i][1],i));
                arr[wires[i][1]].add(new Node(wires[i][0],i));
            }
            
            for(int i=0;i<n-1;i++){
                //i번 간선 끊기
                
                boolean visited[] = new boolean[n+1];

                Queue<Integer> q =new LinkedList<>();
                q.add(1);
                visited[1]=true;
                int cnt=1;
                while(!q.isEmpty()){
                    int nowIndex = q.poll();
                    
                    for(Node nextNode : arr[nowIndex]){
                        if(nextNode.num==i || visited[nextNode.index]){
                            continue;
                        }
                        
                        q.add(nextNode.index);
                        visited[nextNode.index]=true;
                        cnt++;
                        
                    }
                    
                }
                
                
                
                answer=Integer.min(answer,Math.abs(n-cnt-cnt));
                
                
            }
            
            
            return answer;
        }
        
        public class Node{
            int index;
            int num;

            public Node(int index, int num) {
                this.index = index;
                this.num = num;
            }
        }
}