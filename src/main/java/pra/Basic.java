package pra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basic {

    //String 클래스 split 메서드 ""으로 split
    public String[] stringSplitMethod(String s){
        String[] split = s.split("");   //""으로 split

        for (String string : split) {
            System.out.println("string = " + string);
        }

        return split;
    }

    //배열 정렬, 복사
    public int[] arraySort(int []arr){
        int []tmpArr = Arrays.copyOf(arr, arr.length);

        //primitive 타입 배열 오름차순 정렬
        Arrays.sort(tmpArr);

        //내림차순 정렬
        Integer[] integerArr = new Integer[] {1,3,5,2,4};
        Arrays.sort(integerArr,Comparator.reverseOrder());

        return tmpArr;
    }
}
