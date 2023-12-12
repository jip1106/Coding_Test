package lv1;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class LV1 {
    public static void main(String[] args) {
        LV1 lv1 = new LV1();
        lv1.receiveReportResult(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2
        );

        System.out.println("======================");
        lv1.receiveReportResult(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3
        );
    }

    //신고결과 받기
    /*
        - 각 유저는 한 번에 한 명의 유저를 신고할 수 있음
         - 신고 횟수에 제한은 없고 서로 다른 유저를 계속 신고할 수 있음
         - 한 유저를 여러 번 신고할 수 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됌

        - k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
         - 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송

         이용자의 ID가 담긴 문자열 배열 id_list,
         각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report,
         정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때,
         각 유저별로
         처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
     */

    public int[] receiveReportResult(String[] id_list, String[] report, int k) {
        int[] answer = {};
        int userLen = id_list.length;
        answer = new int[userLen];

        HashMap<String, Integer> idxMap = new HashMap<String, Integer>();
        //사용자 , IDX
        for(int i=0; i<userLen; i++){
            idxMap.put(id_list[i], i);
        }

        //key:신고 당한사람 		value: 신고한 사람의 idx를 기록할 list
        HashMap<String, ArrayList<Integer>> listMap = new HashMap<String, ArrayList<Integer>>();

        //report => A B 형식 , A가 B를 신고
        for(String reportVal : report){
            String[] idArr = reportVal.split(" ");
            String AId = idArr[0];		//신고한 사람
            String BId = idArr[1];		//신고 당한사람

            if( !listMap.containsKey(BId)){
                listMap.put(BId, new ArrayList<Integer>());
            }

            ArrayList<Integer> tmp = listMap.get(BId);
            if(!tmp.contains(idxMap.get(AId))){
                tmp.add(idxMap.get(AId));
            }
        }

        System.out.println("===============");
        System.out.println("idxMap :: " + idxMap);
        System.out.println("===============");
        System.out.println("listMap :: " + listMap);


        for(int i=0 ; i<userLen; i++) {
            String userId = id_list[i];
            if(listMap.containsKey(userId) && listMap.get(userId).size() >= k) {
                for(int idx : listMap.get(userId)) {
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}
