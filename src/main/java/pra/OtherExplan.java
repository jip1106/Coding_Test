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


    /**
     * 숫자의 표현
     Finn은 요즘 수학공부에 빠져 있습니다.
     수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

     1 + 2 + 3 + 4 + 5 = 15
     4 + 5 + 6 = 15
     7 + 8 = 15
     15 = 15
     자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

     제한사항
     n은 10,000 이하의 자연수 입니다.


     주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다.
     * */
    public int numExpress(int num){
        int answer = 0;
        for(int i=1; i<=num; i+=2){
            if(num%i == 0){
                answer ++;
            }
        }

        return answer;
    }

    public int numExpress2(int num){
        int answer = 0;

        for(int i=1; i <= num; i++){

            int temp = 0;
            for(int j=i; j<=num; j++){
                temp = temp + j;
                if(temp == num){
                    answer++;
                    break;
                }else if(temp>num){
                    break;
                }
            }
        }

        return answer;
    }

    /**
     * 다음 큰 숫자 ( Integer.bitCount(int n)  => int n 숫자를 binary로 변환 후 1의 수를 반환)
     * @param n
     * @return
     */
    public int nextLargeNum(int n){
        int oneCnt = Integer.bitCount(n);
        int answer = n+1;

        while(true) {
            if(Integer.bitCount(answer)==oneCnt)
                break;

            answer++;
        }

        return answer;
    }
}
