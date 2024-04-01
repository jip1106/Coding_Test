package pra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//연속된 숫자, 문자 판별
public class MyValidPassword {


    /**
     * 비밀번호 검증 메소드
     *
     * @param password 비밀번호 문자열
     * @return 오류코드
     */
    public static String isValidPassword(String password) {
        //연속된숫자 체크 (3자리)
        if(consecutivePossible(password,3)){
            return "CP";
        }

        return "AP";
    }

    public static boolean consecutivePossible(String pwd, int minLength) {
        for (int i = 0; i < pwd.length() - minLength + 1; i++) {
            String substring = pwd.substring(i, i + minLength);

            if (isConsecutive(substring)) {
                return true;
            }
        }
        
        return false;
    }

    // 주어진 문자열이 연속된 문자 또는 숫자인지 확인하는 메서드
    public static boolean isConsecutive(String subStr) {

        int firstChar = subStr.charAt(0);
        boolean sequential = true;

        // 오름차순인지 확인
        boolean ascending = true;
        // 내림차순인지 확인
        boolean descending = true;


        int prevChar = firstChar;

        if(checkAscii(prevChar)){
            return false;
        }

        // 문자열의 각 글자에 대해 순회
        for (int i = 1; i < subStr.length(); i++) {
            // 현재 글자의 ASCII 코드
            int currentChar = subStr.charAt(i);

            // 이전 글자와 현재 글자가 연속된 숫자인지 확인
            if (( currentChar != prevChar + 1) && (currentChar != prevChar - 1)) {
                sequential = false;
            }
            // 오름차순인지 확인
            if (currentChar <= prevChar) {
                ascending = false;
            }
            // 내림차순인지 확인
            if (currentChar >= prevChar) {
                descending = false;
            }
            // 이전 글자 업데이트
            prevChar = currentChar;
        }
        // 연속된 숫자열이면서, 오름차순 또는 내림차순이면 연속된 숫자열로 판단
        return sequential && (ascending || descending);
    }

    //숫자, 영어 소문자,대문자만 검사
    public static boolean checkAscii(int value){
        return !((value >= 65 && value <= 90) || (value >= 97 && value <= 122) || (value >= 48 && value <= 57));
    }
}
