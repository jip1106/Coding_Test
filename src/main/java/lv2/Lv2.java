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
     * @param n     : 끝말잇기 참여 인원
     * @param words : 말하는 단어
     * @return 몇번째 사람이 , 몇번째 차례에 틀리는가?
     */

    public int[] concludingRemarks(int n, String[] words) {
        int[] answer = {0,0};

        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        int j=0;
        for(int i=0; i<words.length; i++){
            //말했던 글자를 말하는 경우
            if(wordMap.containsKey(words[i])){
                wordMap.put(words[i],i);
                j=i+1;
                break;
            }

            //끝말잇기 자체를 틀린 경우
            if(i-1>=0){
                if(!(words[i-1].endsWith(String.valueOf(words[i].charAt(0))))){
                    wordMap.put(words[i],i);
                    j=i+1;
                    break;
                }
            }

            wordMap.put(words[i],i);
        }

        if(wordMap.size() == words.length){
            return answer;
        }else{
            System.out.println("j = " + j);
            answer[0] = j%n == 0 ? (j%n) + n : (j%n);
            answer[1] =(int) Math.ceil(j/(double)n);
        }


        return answer;
    }

    /**
     * 점프와 순간 이동
     * OO 연구소는 한 번에 K 칸을 앞으로 점프하거나,
     * (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동을 할 수 있는 특수한 기능을 가진 아이언 슈트를 개발하여 판매하고 있습니다.
     * 이 아이언 슈트는 건전지로 작동되는데, 순간이동을 하면 건전지 사용량이 줄지 않지만,
     * 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용량이 듭니다. 그러므로 아이언 슈트를 착용하고 이동할 때는 순간 이동을 하는 것이 더 효율적입니다.
     * 아이언 슈트 구매자는 아이언 슈트를 착용하고 거리가 N 만큼 떨어져 있는 장소로 가려고 합니다.
     * 단, 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하려고 합니다.
     * 아이언 슈트 구매자가 이동하려는 거리 N이 주어졌을 때, 사용해야 하는 건전지 사용량의 최솟값을 return하는 solution 함수를 만들어 주세요.
     *
     * 예를 들어 거리가 5만큼 떨어져 있는 장소로 가려고 합니다.
     * 아이언 슈트를 입고 거리가 5만큼 떨어져 있는 장소로 갈 수 있는 경우의 수는 여러 가지입니다.
     *
     * 처음 위치 0 에서 5 칸을 앞으로 점프하면 바로 도착하지만, 건전지 사용량이 5 만큼 듭니다.
     * 처음 위치 0 에서 2 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 2) x 2에 해당하는 위치로 이동할 수 있으므로 위치 4로 이동합니다.
     * 이때 1 칸을 앞으로 점프하면 도착하므로 건전지 사용량이 3 만큼 듭니다.
     *
     * 처음 위치 0 에서 1 칸을 앞으로 점프한 다음 순간이동 하면 (현재까지 온 거리 : 1) x 2에 해당하는 위치로 이동할 수 있으므로 위치 2로 이동됩니다.
     * 이때 다시 순간이동 하면 (현재까지 온 거리 : 2) x 2 만큼 이동할 수 있으므로 위치 4로 이동합니다.
     * 이때 1 칸을 앞으로 점프하면 도착하므로 건전지 사용량이 2 만큼 듭니다.
     *
     * 위의 3가지 경우 거리가 5만큼 떨어져 있는 장소로 가기 위해서 3번째 경우가 건전지 사용량이 가장 적으므로 답은 2가 됩니다.
     * @param n : 1이상 10억 이하의 자연수, 숫자 K : 1 이상의 자연수
     * @return
     */
    public int jumpAndTeleportation(int n){
        int ans = 0;

        while(n != 0){
            if(n%2==0){
                n = n/2;
            }else{
                n--;
                ans++;
            }
        }

        return ans;
    }

    /**
     * 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
     *
     * 예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면
     * 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
     *
     * 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
     *
     * 사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
     * 각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
     * 구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
     * 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다
     * @param people
     * @param limit
     * @return
     */
    public int lifeboat(int[] people, int limit){
        int answer = 0;

        Arrays.sort(people);

        int minIdx = 0;
        int maxIdx = people.length - 1;

        while(maxIdx>=minIdx){
            if(people[maxIdx] + people[minIdx]  <= limit){
                answer++;
                maxIdx--;
                minIdx++;
            }else{
                answer++;
                maxIdx--;
            }
        }

        return answer;
    }

    /**
     * n개의 최소 공배수
     * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
     * 예를 들어 2와 7의 최소공배수는 14가 됩니다.
     * 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
     * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
     */
    public int lcmN(int[] arr){
        int answer = 0;

        int len = arr.length;
        if(len == 1){
            return arr[0];
        }

        answer = getLCM(arr[0],arr[1]);

        for(int i=1; i<len-1; i++){
            answer = getLCM(answer, arr[i+1]);
        }

        return answer;
    }

    /**
     * 두 수의 최대 공약수
     * @param a
     * @param b
     * @return
     */
    public int getGCD(int a, int b){
        int tmp = 0;
        int n = 0;

        if(a<b){
            tmp = a;
            a = b;
            b = tmp;
        }

        while(b!=0){
            n = a%b;
            a = b;
            b = n;
        }

        return a;
    }
    /**
     * 두 수의 최소 공배수
     * @param a
     * @param b
     * @return
     */
    public int getLCM(int a, int b){
        return (a*b) / getGCD(a,b);
    }


    /**
     * 멀리뛰기
     *
     * 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
     * 멀리뛰기에 사용될 칸의 수 n이 주어질 때,
     * 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
     * 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.
     * 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
     *
     * 제한 사항
     * n은 1 이상, 2000 이하인 정수입니다.
     */
    public long longJump(int n){
        long answer = 0;

        //3,5,8,13 ... 피보나치
        long[] dp = new long[n+2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n ;i++){
            dp[i] = ( dp[i-1] + dp[i-2] ) % 1234567;
        }
        answer = dp[n];

        return answer;
    }

    /**
     * 귤고르기
     * 확한 귤 중 'k'개를 골라 상자 하나에 담아 판매
     * 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 경화가 귤 6개를 판매하고 싶다면,
     * 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때임
     * 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다
     * 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return
     * @param k
     * @param tangerine
     * @return
     */
    public int chooseMandarin(int k, int[] tangerine){
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0) + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());

        //값 기준 내림차순 정렬
        keys.sort( (tmp1, tmp2) -> map.get(tmp2) - map.get(tmp1) );

        int i=0;
        while(k > 0){
            k -= map.get(keys.get(i));
            answer ++;
            i++;
        }

        return answer;
    }

    /**
     * 연속 부분 수열 합의 개수
     */
    public int continuitySequence(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        int start = 1;
        while (start <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int value = 0;
                for (int j = i; j < i + start; j++) {
                    value += elements[j % elements.length];
                }
                set.add(value);
            }
            start++;
        }

        answer = set.size();

        return answer;
    }

    /**
     * 괄호 회전하기
     */

    public int rotationBracket(String s){
        int answer = 0;

        //올바른 괄호가 맞는지 확인
        int len = s.length();
        //System.out.println("s = " + s);

        for(int i=0; i<len; i++){
            s = s.substring(1) + s.charAt(0);
            //System.out.println("s = " + s);
            answer = rightBracketV2(s) ? answer + 1 : answer;
        }

        return answer;
    }

    public boolean rightBracketV2(String s){
        boolean rtnVal = false;
        ArrayList<Character> startBracket = new ArrayList<>(Arrays.asList('(','{','['));
        ArrayList<Character> endBracket = new ArrayList<>(Arrays.asList(')','}',']'));

        if(endBracket.contains(s.charAt(0))){
            return rtnVal;
        }

        Stack<Character> stack = new Stack<>();
        int len = s.length();

        // [] () {}
        for(int i=0; i<len;i++){
            char val = s.charAt(i);

            if(stack.empty()){
                stack.push(val);
            }else{
                char peekVal = stack.peek();

                if(startBracket.contains(val)){
                    stack.push(val);
                }

                if(peekVal == '{' && val == '}') stack.pop();
                if(peekVal == '[' && val == ']') stack.pop();
                if(peekVal == '(' && val == ')') stack.pop();

                if(endBracket.contains(peekVal)){
                    rtnVal = false;
                    break;
                }
            }


        }

        rtnVal = stack.empty();

        return rtnVal;
    }


    /**
     * 할인행사
     *  일정한 금액을 지불하면 10일 동안 회원 자격을 부여
     *  회원을 대상으로 매일 한 가지 제품을 할인하는 행사, 할인하는 제품은 하루에 하나씩만 구매
     *  자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입
     *   원하는 제품이 바나나 3개, 사과 2개, 쌀 2개, 돼지고기 2개, 냄비 1개이며
     *   15일간 회원을 대상으로 할인하는 제품이 날짜 순서대로
     *   치킨, 사과, 사과, 바나나, 쌀, 사과, 돼지고기, 바나나, 돼지고기, 쌀, 냄비, 바나나, 사과, 바나나인 경우
     *   첫째 날부터 열흘 간에는 냄비가 할인하지 않기 때문에 첫째 날에는 회원가입을 하지 않습니다.
     *   둘째 날부터 열흘 간에는 바나나를 원하는 만큼 할인구매할 수 없기 때문에 둘째 날에도 회원가입을 하지 않습니다.
     *   셋째 날, 넷째 날, 다섯째 날부터 각각 열흘은 원하는 제품과 수량이 일치하기 때문에 셋 중 하루에 회원가입
     *
     * */
    public int discountEvent(String[] want, int[] number, String[] discount){
        int answer = 0;
        int discountDay = 10;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<number.length; i++){
            map.put(want[i], number[i]);
        }

        for(int i=0; i<=discount.length - discountDay;i++){

            Map<String, Integer> dMap = new HashMap<>();

            for(int j = 0; j < discountDay; j++){
                dMap.put(discount[i + j], dMap.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean chk = true;

            for(String key : map.keySet()){
                if(!map.get(key).equals(dMap.get(key)) ){
                    chk = false;
                    break;
                }
            }

            answer += chk ? 1 : 0;

        }

        return answer;
    }

    /**
     * n^2 배열 자르기
     * 정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.
     *
     *  1. n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
     *
     *  2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
     *
     *  3. 1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
     *          1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
     *
     *  4. 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
     * 정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.
     */
    public int[] splitArr(int n, long left, long right){

        int[] answer = new int[(int)(right - left) + 1];

        for(int i = 0; i < answer.length; i++){
            int row = (int)((i + left) / n) + 1; // 행
            int col = (int)((i + left) % n) + 1; // 열
            answer[i] = Math.max(row, col);
        }


        return answer;
    }

    /**
     * 어떤 과학자가 발표한 논문 n편 중,
     * h번 이상 인용된 논문이 h편 이상 이고 나머지 논문이
     * h번 이하 인용 되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
     *
     * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상일 때의 h값과 그 때, h번 이상 인용된 논문의 개수 중 최대값을 리턴한다.
     * @param citations
     * @return
     */
    public int hIndex(int[] citations){
        int answer = 0;

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public int [][] matrixMultiply(int[][] arr1, int[][] arr2){
        int arr1R = arr1.length;
        int arr1C = arr1[0].length;

        int arr2R = arr1C;
        int arr2C = arr2[0].length;

        int[][] answer = new int[arr1R][arr2C];

        for(int r=0;r<arr1R;r++){

            for(int c=0;c<arr2C;c++){
                int sum = 0;

                for(int k=0;k<arr1C;k++){
                    sum += arr1[r][k]*arr2[k][c];
                }
                answer[r][c] = sum;
            }
        }

        return answer;
    }






}
