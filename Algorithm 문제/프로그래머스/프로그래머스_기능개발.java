import java.util.*;

 public class Solution{
        public int[] solution(int[] progresses, int[] speeds) {
            int[] endTime = new int[progresses.length];
            
            for(int i=0;i<progresses.length;i++){
                endTime[i] = (100-progresses[i])/speeds[i];
                if((100-progresses[i])%speeds[i]!=0){
                    endTime[i]++;
                }
            }
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            int cnt=1;
            int time = endTime[0];
            for(int i=1;i<progresses.length;i++){
                if(time >= endTime[i] ){
                    cnt++;
                }
                else{
                    arr.add(cnt);
                    cnt=1;
                    time=endTime[i];

                }
            }
            arr.add(cnt);
            
            int result[] = new int[arr.size()];
            
            for(int i=0;i<arr.size();i++){
                result[i]=arr.get(i);
            }
            
            
            return result;
        }
    }