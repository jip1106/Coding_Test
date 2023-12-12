package lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lv0 {

    /***
     * 옹알이 (1)
     * 문제 설명
     * "aya" "ye" "woo" "ma" 최대 한 번씩 사용해 조합한(이어붙인) 발음만 할 수 있음.
     * 문자열배열 babbling가 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return
     *
     * 1 ≤ babbling의 길이 ≤ 100
     * 1 ≤ babbling[i]의 길이 ≤ 15
     * babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
     * 즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
     * 문자열은 알파벳 소문자로만 이루어져 있습니다.
     ** */
    public int beforeBabble(String[] babbling){
        int answer = 0;

        ArrayList<String> words = new ArrayList<String>();
        words.add("aya");
        words.add("ye");
        words.add("woo");
        words.add("ma");


        List<String> babblingList = Arrays.asList(babbling);

        for(String tmp : babblingList){
            for(String word : words){
                if(tmp.contains(word)){
                    tmp = tmp.replaceFirst(word," ");
                }
            }

            if(tmp.trim().length() == 0){
                answer++;
            }

        }

        return answer;
    }

    public int babble(String[] babbling){
        int rtnVal = 0;

        ArrayList<String> whiteList = new ArrayList<String>();
        whiteList.add("aya");
        whiteList.add("ye");
        whiteList.add("woo");
        whiteList.add("ma");

        for(String tmpStr : babbling){
            for(String whiteStr : whiteList){
                tmpStr  = tmpStr.contains(whiteStr) ? tmpStr.replace(whiteStr,"1") : tmpStr;
            }

            tmpStr = tmpStr.replace("1","");
            if(tmpStr.equals("")){  //tmpStr.isEmpty()
                rtnVal++;
            }
        }

        return rtnVal;
    }


    /**
     * 점 네 개의 좌표를 담은 이차원 배열 dots 가 매개변수로 주어짐 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
     * 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
     * @param dots
     * @return
     */
    public int parallel(int[][] dots){
        int rtnVal = 0;

        int x1,x2,x3,x4;
        int y1,y2,y3,y4;

        x1 = dots[0][0];
        y1 = dots[0][1];

        x2 = dots[1][0];
        y2 = dots[1][1];

        x3 = dots[2][0];
        y3 = dots[2][1];

        x4 = dots[3][0];
        y4 = dots[3][1];


        //[a-b,  c-d]
        //[a-c , b-d]
        //[a-d , b-c]

        // a : x1,y1
        // b : x2,y2
        // c : x3,y3
        // d : x4,y4

        double iAB = getIncline2(x1,x2,y1,y2);
        double iCD = getIncline2(x3,x4,y3,y4);

        double iAC = getIncline2(x1,x3,y1,y3);
        double iDB = getIncline2(x2,x4,y2,y4);

        double iAD = getIncline2(x1,x4,y1,y4);
        double iBC = getIncline2(x2,x3,y2,y3);

        if(iAB == iCD || iAC == iDB || iAD == iBC){
            return 1;
        }


        return 0;
    }

    public double getIncline2(int x1, int x2, int y1, int y2){
        double rtnVal = 0;
        double xDiff = Math.abs(x2-x1);
        double yDiff = Math.abs(y2-y1);

        rtnVal = (yDiff / xDiff);

        return rtnVal;
    }
    public int[] getIncline(int x1, int x2, int y1, int y2){
        int [] rtnVal = new int[2];

        int xDiff = Math.abs(x2-x1);
        int yDiff = Math.abs(y2-y1);

        int gcd = getGcd(xDiff, yDiff);

        rtnVal[0] = xDiff/gcd;
        rtnVal[1] = yDiff/gcd;

        return rtnVal;
    }

    //최대공약수
    public int getGcd(int a, int b){
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


    //짝수의 합
    public int sumEven(int n){
        /*
        int answer = 0;

        for(int i=0; i<=n; i+=2){
            answer += i;
        }
        return answer;
        */
        return IntStream.rangeClosed(0,n).filter(tmp -> tmp%2==0).sum();
    }

    //배열의 평균값
    public double avgArrays(int[] numbers){
        /*
        double answer = 0;

        for(int tmp : numbers){
            answer += tmp;
        }

        answer /= numbers.length;

        return answer;
        */
        return Arrays.stream(numbers).average().orElse(0);
    }

    //배열 원소의 길이
    public int[] arrayValueLength(String[] strList){

        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }

    //배열 자르기
    public int[] sliceArrays(int[] numbers, int num1, int num2){
        return IntStream.rangeClosed(num1, num2).map(x -> numbers[x]).toArray();
    }

    //중복된 숫자 개수
    public int dupNumCount(int []array, int n){
        return (int)Arrays.stream(array).filter(x -> x==n).count();
    }

    //배열 뒤집기
    public int[] reverseArrays(int[] num_list){
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        Collections.reverse(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    //머쓱이보다 키 큰 사람
    public int tallerThanMeosseug(int[] array, int height){
        int count = (int)Arrays.stream(array).filter(i -> i > height).count();

        return count;
    }
    //
    public int[] even_oddCnt(int[] num_list){
        //정수가 담긴 리스트 num_list가 주어질 때, num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

        return IntStream.of(
                (int) Arrays.stream(num_list).filter(i -> i % 2 == 0).count(),
                (int) Arrays.stream(num_list).filter(i -> i % 2 == 1).count()
        ).toArray();

    }
    //순서쌍의 개수
    public int orderedPairCnt(int n){
        /*
        순서쌍이란 두 개의 숫자를 순서를 정하여 짝지어 나타낸 쌍으로 (a, b)로 표기합니다.
        자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return하도록 solution 함수를 완성해주세요.
         */
        return (int)IntStream.rangeClosed(1,n).filter(value -> n%value ==0).count();
    }

    //배열의 유사도
    public int arraysSimilarity(String[] s1, String[] s2) {
        return (int) Arrays.stream(s1)
                .filter(s1Element -> Arrays.asList(s2).contains(s1Element))
                .count();

    }

}
