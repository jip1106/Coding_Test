package pra;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BasicTest {
    @Test
    public void stringSplitMethod() throws Exception {
        //given
        String s = "abcd efg  hijk lmn opqrstu vwxyz";
        
        Basic basic = new Basic();
        String[] arr = basic.stringSplitMethod(s);


        Assertions.assertThat(arr.length).isEqualTo(s.length());

    }

    @Test
    public void arraySort() throws Exception {
        int[] intArr = {8,7,6,5,4};

        Arrays.sort(intArr); // 오름차순 정렬
        for (int i : intArr) {
            System.out.println("primitive type = " + i);
        }

        //내림차순 정렬시 primitive type 배열은 적용 불가능
        Integer[] integerArr = {1,2,3,4,5};
        Arrays.sort(integerArr, Collections.reverseOrder()); // 내림차순 정렬
        for (Integer i : integerArr) {
            System.out.println("Integer Type = " + i);
        }

    }

}