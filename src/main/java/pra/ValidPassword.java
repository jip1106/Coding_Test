package pra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword {


    public static void main(String[] args) {
        System.out.println(ValidPassword.isValidPassword("csh0325!","1111279","",""));
    }

    /**
     * 비밀번호 검증 메소드
     * 회사소스 오류....(연속된 숫자만 일단 체크)
     *
     * @param password 비밀번호 문자열
     * @return 오류코드
     */
    public static String isValidPassword(String password, String id, String phonNum, String birth) {
        // 최소 8자, 최대 16자 상수 선언
        final int MIN = 8;
        final int MAX = 16;

        // 영어, 숫자, 특수문자 포함한 MIN to MAX 글자 정규식, 특수문자
        //final String REGEX = "^((?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W]).{" + MIN + "," + MAX + "})$";
        final String REGEX ="^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*?_~])(?=\\S+$).{" + MIN + "," + MAX + "}$";
        // 3자리 연속 문자 정규식
        final String SAMEPT = "(\\w)\\1\\1";

        // 정규식 검사객체
        Matcher matcher;

        // 공백 체크
        if (password == null || "".equals(password)) {
            return "WR";
        }

        // ASCII 문자 비교를 위한 UpperCase
        String tmpPw = password.toUpperCase();
        // 문자열 길이
        int strLen = tmpPw.length();

        // 글자 길이 체크
	    /*if (strLen > 16 || strLen < 8) {
	      return "Detected: Incorrect Length(Length: " + strLen + ")";
	    }*/

        // 비밀번호 정규식 체크
        matcher = Pattern.compile(REGEX).matcher(tmpPw);
        if (!matcher.find()) {
            return "WR";
        }

        // 동일한 문자 3개 이상 체크
        matcher = Pattern.compile(SAMEPT).matcher(tmpPw);
        if (matcher.find()) {
            return "SW";
        }

        // ASCII Char를 담을 배열 선언
        int[] tmpArray = new int[strLen];

        // Make Array
        for (int i = 0; i < strLen; i++) {
            tmpArray[i] = tmpPw.charAt(i);
        }

        //연속된숫자 체크 (3자리)
        if(consecutivePossible(tmpPw,3)){
            return "CP";
        }

        //아이디와 동일한지 체크
        if(id != null && password.contains(id)) {
            return "PS";
        }

        //휴대폰 번호와 동일한지 체크 4자리수 체킹
        if(phonNum != null && !"".equals(phonNum)) {
            //String phoneRegEx = "(\\d{3})(\\d{3,4})(\\d{4})";
            //phonNum = phonNum.replaceAll(phoneRegEx, "$2") + phonNum.replaceAll(phoneRegEx, "$3");

            for (int i = 0; i < password.length() - 3; i++) {
                if (phonNum.contains(password.substring(i, i + 3))) {
                    return "PS";
                }
            }
        }

        //생일과 동일한지 체크
        if(birth != null && !"".equals(birth)) {
            String birthRegEx = "(\\d{4})(\\d{4})";
            birth = birth.replaceAll(birthRegEx, "$2");

            if(password.contains(birth)){
                return "PS";
            }
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
    public static boolean isConsecutive(String pwd) {

        boolean ascending = true;
        boolean descending = true;

        int prevChar = pwd.charAt(0);

        for (int i = 1; i < pwd.length(); i++) {

            int currentChar = pwd.charAt(i);
            // 오름차순 확인
            if (currentChar != prevChar + 1) {
                ascending = false;
            }

            // 내림차순 확인
            if (currentChar != prevChar - 1) {
                descending = false;
            }

            prevChar = currentChar;
        }

        // 오름차순이거나 내림차순이면 연속된 숫자열이라고 판단
        return ascending || descending;
    }
}
