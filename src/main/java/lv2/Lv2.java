package lv2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
            sum += i;

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

    /**
     * 다음 큰 숫자
     * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
     *
     * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
     * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환 했을 때 1의 갯수가 같습니다.
     * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
     * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
     *
     * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
     * @param n
     * @return
     */
    public int nextLargeNum(int n){
        int answer = 0;

        String nBinary = Integer.toBinaryString(n);
        int oneCnt = getOneCount(nBinary);
        int nextOneCnt = 0;

        int tmp = n;

        while(true){
            tmp+=1;
            String nextBinary = Integer.toBinaryString(tmp);
            nextOneCnt = getOneCount(nextBinary);

            if(nextOneCnt == oneCnt){
                answer = tmp;
                break;
            }
        }

        return answer;
    }

    private int getOneCount(String s){
        int rtnVal = 0;
        for (char c : s.toCharArray()) {
            if(c=='1'){
                rtnVal ++;
            }
        }
        return rtnVal;
    }


    /**
     * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
     *
     * 예를들어
     *
     * F(2) = F(0) + F(1) = 0 + 1 = 1
     * F(3) = F(1) + F(2) = 1 + 1 = 2
     * F(4) = F(2) + F(3) = 1 + 2 = 3
     * F(5) = F(3) + F(4) = 2 + 3 = 5
     * 와 같이 이어집니다.
     *
     * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
     * @param n
     * @return
     */
    public int fibonacciNum(int n){
        int answer = 0;

        if(n == 1 || n == 0) return 1;

        int fibo1 = 0;
        int fibo2 = 1;

        for(int i = 2; i <= n; i++){
            answer = (fibo1+fibo2) % 1234567;
            fibo1 = fibo2;
            fibo2 = answer;
        }

        return answer;

    }

    private int calFiboRecursive(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return calFiboRecursive(n-1) + calFiboRecursive(n-2);
        }
    }

    public int calFiboFor(int n){
        int fibo1 = 0;
        int fibo2 = 1;
        int fibo3 = 0;

        for(int i=2; i<=n; i++){
            fibo3 = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibo3;

        }

        return fibo3;
    }

    /**
     * 짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다.
     * 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다.
     * 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
     * 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요.
     *
     * 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
     *
     * 예를 들어, 문자열 S = baabaa 라면
     *
     * b aa baa → bb aa → aa →
     *
     * 의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
     * @param s
     * @return
     */
    public int removePair(String s){
        int answer = -1;

        int len = s.length();

        for(int i=1; i<len; i++){

            if(s.charAt(i) == s.charAt(i-1)){
                String removeVal = s.substring(i-1,i+1);
                s = s.replace(removeVal,"");
                i = 0;
                len = s.length();
            }

            if(s.isEmpty()) break;
        }
        answer = s.isEmpty() ? 1 : 0;

        return answer;
    }

    public int removePair2(String s){
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();

        char []arr = s.toCharArray();

        char nowVal = ' ';

        for(int i=0; i<arr.length; i++){
            if(!stack.isEmpty()){
                if(arr[i] == stack.peek() ){
                    stack.pop();
                    continue;
                }
            }

            stack.push(arr[i]);
        }

        answer = stack.isEmpty() ? 1: 0;
        return answer;

    }

    public int[] cappet(int brown, int yellow){
        int[] answer = new int[2];


        int area = brown + yellow;

        for(int i=3; i<=area; i++){
            int col = i;

            if(area%col != 0){
                continue;
            }

            int row = area / col;

            if(row < 3 ){
                continue;
            }

            if(row >= col){
                if( (row-2) * (col -2) == yellow){
                    answer[0] = row;
                    answer[1] = col;
                }
            }
        }

        return answer;
    }

    /**
     * 영어 끝말잇기
     * @param n
     * @param words
     * @return
     */

    public int[] concludingRemarks(int n, String[] words) {
        int[] answer = {0,0};

        return answer;
    }







}
