package lv0;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pra.MyValidPassword;

import static org.assertj.core.api.Assertions.assertThat;

public class LV0Test {

    Lv0 lv0 = new Lv0();

    @DisplayName("LV0 - 옹알이(1)")
    @Test
    public void babblingTest(){
        Lv0 lv0 = new Lv0();
        //given
        int rtnVal = lv0.babble(new String[]{"aya", "yee", "u", "maa", "wyeoo"});
        assertThat(rtnVal).isEqualTo(1);

        rtnVal = lv0.babble(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"});
        assertThat(rtnVal).isEqualTo(3);

    }

    @DisplayName("LV0 - 최대공약수")
    @Test
    public void gcd(){
        Lv0 lv0 = new Lv0();

        int rtnVal = lv0.getGcd(2,9);
        assertThat(rtnVal).isEqualTo(1);
    }
    
    @DisplayName("LV0 - 평행")
    @Test
    public void parallel(){
        /**
         * [[1, 4], [9, 2], [3, 8], [11, 6]]
         * [[3, 5], [4, 1], [2, 4], [5, 10]]
         */
        int [][] dots = {
                {1,4},
                {9,2},
                {3,8},
                {11,6},

        };
        assertThat(lv0.parallel(dots)).isEqualTo(1);

        int [][]dots2 = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};

        assertThat(lv0.parallel(dots2)).isEqualTo(0);
    }

    @Test
    public void sumEven() throws Exception {
        //2 4 6 8 10
        assertThat(lv0.sumEven(10)).isEqualTo(30);
    }

    @Test
    public void avgArrays() throws Exception {
        int numbers[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        int numbers2[] = new int []{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};

        assertThat(lv0.avgArrays(numbers)).isEqualTo(5.5);
        assertThat(lv0.avgArrays(numbers2)).isEqualTo(94.0);
    }

    @Test
    public void dupNumCount() throws Exception {
        int array[] = {1,1,2,3,4,5};
        int array2[] ={0,2,3,4};

        assertThat(lv0.dupNumCount(array,1)).isEqualTo(2);
        assertThat(lv0.dupNumCount(array2,1)).isEqualTo(0);
    }

    @Test
    public void sliceArrays() throws Exception {
        int numbers[] = new int[]{1,2,3,4,5};
        int num1 = 1;
        int num2 = 3;

        int[] ints = lv0.sliceArrays(numbers, num1, num2);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }

        int numbers2[] = new int[]{1,3,5};
        num1 = 1;
        num2 = 2;

        int[] ints1 = lv0.sliceArrays(numbers2, num1, num2);
        for (int i : ints1) {
            System.out.println("i = " + i);
        }
    }
    
    
    @Test
    public void passwordTest() throws Exception {
        System.out.println("MyValidPassword.isValidPassword(\"csh0325!\") = " + MyValidPassword.isValidPassword("csh0325!"));

        assertThat(MyValidPassword.isValidPassword("84232005wnsdlF!")).isEqualTo("AP");
        assertThat(MyValidPassword.isValidPassword("abc!")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("cba!")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("bca!")).isEqualTo("AP");
        assertThat(MyValidPassword.isValidPassword("xyz!")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("zyx!")).isEqualTo("CP");

        assertThat(MyValidPassword.isValidPassword("csh0325!")).isEqualTo("AP");
        assertThat(MyValidPassword.isValidPassword("opqrstu")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("opq")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("stu")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("tu")).isEqualTo("AP");
        assertThat(MyValidPassword.isValidPassword("tuut")).isEqualTo("AP");


        assertThat(MyValidPassword.isValidPassword("123")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("321")).isEqualTo("CP");

        assertThat(MyValidPassword.isValidPassword("321")).isEqualTo("CP");

        //abcdefg hijklmn opqrstu vwxyz
        assertThat(MyValidPassword.isValidPassword("xyz")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("zyx")).isEqualTo("CP");
        assertThat(MyValidPassword.isValidPassword("zab")).isEqualTo("AP");

        assertThat(MyValidPassword.isValidPassword("zyk!")).isEqualTo("AP");


    }


}