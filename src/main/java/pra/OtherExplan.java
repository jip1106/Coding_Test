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

    //올바른 괄호
    public boolean rightBracket(String s){
        boolean answer = false;
        int count = 0;
        int len = s.length();

        for(int i = 0; i<len;i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    }
}
