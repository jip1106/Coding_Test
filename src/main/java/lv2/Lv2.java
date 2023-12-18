package lv2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lv2 {
    //최댓값과 최솟값
    public String maxOrmin(String s){
        /**
         * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
         * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
         * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
         */
        String answer = "";

        String[] s1 = s.split(" ");

        int tmpMin = Integer.parseInt(s1[0]);
        int tmpMax = tmpMin;

        for(int i=1; i<s1.length; i++){
            int nowVal = Integer.parseInt(s1[i]);
            tmpMax = Math.max(tmpMax,nowVal);
            tmpMin = Math.min(tmpMin,nowVal);
        }

        answer = tmpMin + " " + tmpMax;

        return answer;
    }

    //JadenCase 문자열 만들기
    public String makeJadenCaseString(String s){
        /**
         * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
         * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
         * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
         */

        String answer = "";
        char[] charArray = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<charArray.length; i++){
            char nowVal = charArray[i];

            //숫자인경우
            if(nowVal >= '0' && nowVal <= '9'){
                sb.append(nowVal);
            }else{
                if(i==0){
                    sb.append(makeLowerToUpper(nowVal));
                }else {
                    if(nowVal!= ' ' && charArray[i-1] == ' '){
                        sb.append(makeLowerToUpper(nowVal));
                    }else{
                        sb.append(makeUpperToLower(nowVal));
                    }
                }
            }
        }

        answer = sb.toString();

        return answer;

    }

    //대문자 -> 소문자
    private char makeUpperToLower(char base){
        if(base >= 'A' && base <= 'Z'){
            base += 32;
        }

        return base;
    }

    private char makeLowerToUpper(char base){
        if(base >= 'a' && base <='z'){
            base -=32;
        }

        return base;
    }


    //최솟값 만들기
    public int makeMinVal(int []A, int []B){
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++){
            answer += A[i] * B[A.length - (i+1)];
        }

        return answer;
    }

    //올바른 괄호
    public boolean rightBracket(String s){
        boolean answer = true;
        if(s.startsWith(")") || s.endsWith("(")){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        answer = stack.isEmpty();

        return answer;

    }

    //숫자의 표현
    /**

     Finn은 요즘 수학공부에 빠져 있습니다.
     수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

    1 + 2 + 3 + 4 + 5 = 15
    4 + 5 + 6 = 15
    7 + 8 = 15
    15 = 15
자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

제한사항
n은 10,000 이하의 자연수 입니다.
    * */

    public int numExpress(int n){
        int answer = 0;

        int range = n/2 + 1;
        int sum = 0;
        int j=1;
        
        for(int i=j; i <= range; i++){
            System.out.println("i = " + i);
            System.out.println("j = " + j);
            sum += i;
            System.out.println("sum = " + sum);

            if(sum >= n){
                if(sum == n){
                    answer ++;
                }
                j+=1;
                i=j-1;
                sum=0;
            }
        }

        System.out.println("j = " + j);
        //자기자신 -> 반례 2..
        if(j-1!=n)
            answer+=1;

        return answer;
    }







}
