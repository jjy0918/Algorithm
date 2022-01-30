package programmers.y2022;

import java.util.*;

public class pro_0130_오픈채팅방 {
    class Solution {
        public final String ENTER = "Enter";
        public final String LEAVE  = "Leave";
        public final String CHANGE  = "Change";
        Map<String, String> idToNickNameMap = new HashMap<>();

        public String[] solution(String[] record) {

            List<User> userRecords = new ArrayList<>();

            for(String s : record){
                StringTokenizer st = new StringTokenizer(s);

                String input = st.nextToken();

                String id = st.nextToken();
                if(ENTER.equals(input) || CHANGE.equals(input)){
                    String nickname = st.nextToken();
                    idToNickNameMap.put(id,nickname);
                }

                userRecords.add(new User(id,input));

            }

            return userRecords.stream()
                    .filter(User::isNotChange)
                    .map(User::toString)
                    .toArray(String[]::new);

        }

        public class User{
            String id;
            String input;

            public User(String id, String input) {
                this.id = id;
                this.input = input;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(idToNickNameMap.get(id));
                sb.append("님이 ");
                if(ENTER.equals(input)){
                    sb.append("들어왔습니다.");
                }
                else if(LEAVE.equals(input)){
                    sb.append("나갔습니다.");
                }
                return sb.toString();
            }

            public boolean isNotChange(){
                if(CHANGE.equals(input)){
                    return false;
                }
                return true;
            }
        }
    }
}
