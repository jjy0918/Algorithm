import java.util.ArrayList;
import java.io.IOException;
public  class Solution{
        public int solution(String s) {
            int answer = s.length();
            int len = s.length();
            for(int i=1;i<=len/2;i++){

                ArrayList<String> arr = new ArrayList<>();
                for(int j=0;j<len;j+=i){
                    int last = j+i;
                    if(last>=len){
                        last=len;
                    }
                    arr.add(s.substring(j,last));
                }

                int sum=0;
                String prev=arr.get(0);
                int cnt=1;
                for(int j=1;j<arr.size();j++){

                    if(prev.equals(arr.get(j))){
                        cnt++;
                    }
                    else{
                        if(cnt>1){
                            sum+=String.valueOf(cnt).length()+prev.length();
                        }
                        else{
                            sum+=prev.length();
                        }
                        cnt=1;
                        prev=arr.get(j);
                    }

                    if(j==arr.size()-1){
                        if(cnt>1){
                            sum+=String.valueOf(cnt).length();
                        }
                        sum+=prev.length();
                    }

                }

                answer=Integer.min(answer,sum);
            }
            System.out.println(answer);
            return answer;
        }
    }