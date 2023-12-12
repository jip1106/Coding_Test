package pra;

public class OtherExplan {
    public String makeJadenCaseStringV2(String s){
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean check = true;

        for(String ss : sp) {
            answer += check ? ss.toUpperCase() : ss;
            check = ss.equals(" ") ? true : false;
        }

        return answer;

    }
}
