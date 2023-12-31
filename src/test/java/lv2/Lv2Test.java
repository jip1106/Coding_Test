package lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pra.OtherExplan;

import static org.assertj.core.api.Assertions.assertThat;

class Lv2Test {
    Lv2 lv2 = new Lv2();
    OtherExplan ohterExplan = new OtherExplan();

    @Test
    @DisplayName("LV2 - makeJadenCaseString")
    public void makeJadenCaseString() throws Exception {
        String s = "3people unFollowed me";

        String findStr = lv2.makeJadenCaseString(s);
        assertThat(findStr).isEqualTo("3people Unfollowed Me");

        s = "for the last week";
        findStr = lv2.makeJadenCaseString(s);
        assertThat(findStr).isEqualTo("For The Last Week");


        s = "test   test";
        findStr = lv2.makeJadenCaseString(s);
        assertThat(findStr).isEqualTo("Test   Test");

        s = "test   test ";
        findStr = lv2.makeJadenCaseString(s);
        assertThat(findStr).isEqualTo("Test   Test ");
    }

    @Test
    public void makeMinVal() throws Exception {

        int result = lv2.makeMinVal(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        assertThat(result).isEqualTo(29);

        result = lv2.makeMinVal(new int[]{1,2} , new int[]{3,4});
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void rightBracket() throws Exception {


//        assertThat(lv2.rightBracket("()()()()()()")).isTrue();
//        assertThat(lv2.rightBracket("((()))()")).isTrue();
//        assertThat(lv2.rightBracket("((()))())")).isFalse();
//        assertThat(lv2.rightBracket("(((((()))())")).isFalse();
//        assertThat(lv2.rightBracket("((((((")).isFalse();
//        assertThat(lv2.rightBracket("))))))")).isFalse();
//        assertThat(lv2.rightBracket(")")).isFalse();
        assertThat(lv2.rightBracket("())")).isFalse();
        assertThat(lv2.rightBracket("(()")).isFalse();
    }

    @Test
    public void numExpress(){
        //assertThat(lv2.numExpress(15)).isEqualTo(4);
        //assertThat(lv2.numExpress(6)).isEqualTo(2);
        assertThat(lv2.numExpress(2)).isEqualTo(1);
        assertThat(ohterExplan.numExpress2(2)).isEqualTo(1);

    }

    @Test
    public void nextLargeNum() throws Exception {
        assertThat(lv2.nextLargeNum(78)).isEqualTo(83);
        assertThat(lv2.nextLargeNum(15)).isEqualTo(23);
    }


    @Test
    public void removePair() throws Exception {
        //assertThat(lv2.removePair("baabaa")).isEqualTo(1);
        //assertThat(lv2.removePair("bcbc")).isEqualTo(0);

        assertThat(lv2.removePair2("baabaa")).isEqualTo(1);
        assertThat(lv2.removePair2("bcbc")).isEqualTo(0);

        assertThat(lv2.removePair2("a")).isEqualTo(0);
        assertThat(lv2.removePair2("aa")).isEqualTo(1);
        assertThat(lv2.removePair2("aaa")).isEqualTo(0);
    }

    @Test
    public void cappet() throws Exception {
        assertThat(lv2.cappet(10,2)[0]).isEqualTo(4);
        assertThat(lv2.cappet(10,2)[1]).isEqualTo(3);
    }

    @Test
    @DisplayName("concludingRemarks")
    public void concludingRemarks() {
        assertThat(lv2.concludingRemarks(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})[0]).isEqualTo(3);
        assertThat(lv2.concludingRemarks(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})[1]).isEqualTo(3);

        assertThat(lv2.concludingRemarks(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})[0]).isEqualTo(0);
        assertThat(lv2.concludingRemarks(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})[1]).isEqualTo(0);

        assertThat(lv2.concludingRemarks(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"})[0]).isEqualTo(1);
        assertThat(lv2.concludingRemarks(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"})[1]).isEqualTo(3);
    }

    @Test
    @DisplayName("jumpAndTeleportation")
    public void jumpAndTeleportation() throws Exception {
        assertThat(lv2.jumpAndTeleportation(5)).isEqualTo(2);
        assertThat(lv2.jumpAndTeleportation(6)).isEqualTo(2);
        assertThat(lv2.jumpAndTeleportation(5000)).isEqualTo(5);
    }
    
    @Test
    @DisplayName("lifeboat")
    public void lifeboat() throws Exception {
        assertThat(lv2.lifeboat(new int[]{70, 50, 80, 50},100)).isEqualTo(3);
        assertThat(lv2.lifeboat(new int[]{70, 50, 80},100)).isEqualTo(3);
    }

    @Test
    @DisplayName("lcmN")
    public void lcmN() throws Exception {
        assertThat(lv2.lcmN(new int[]{2,6,8,14})).isEqualTo(168);
        assertThat(lv2.lcmN(new int[]{1,2,3})).isEqualTo(6);
    }

    @Test
    @DisplayName("longJump")
    public void longJump() throws Exception {
        assertThat(lv2.longJump(3)).isEqualTo(3);
        assertThat(lv2.longJump(4)).isEqualTo(5);
        assertThat(lv2.longJump(5)).isEqualTo(8);
        assertThat(lv2.longJump(6)).isEqualTo(13);

    }

    @Test
    @DisplayName("rotationBracket")
    public void rotationBracket() throws Exception {
        assertThat(lv2.rotationBracket("[](){}")).isEqualTo(3);
        assertThat(lv2.rotationBracket("}]()[{")).isEqualTo(2);
        assertThat(lv2.rotationBracket("[)(]")).isEqualTo(0);
        assertThat(lv2.rotationBracket("}}}")).isEqualTo(0);
        assertThat(lv2.rotationBracket("()")).isEqualTo(1);

    }

    @Test
    public void rightBracketV2() throws Exception {
        assertThat(lv2.rightBracketV2("}]()[{")).isFalse();
        assertThat(lv2.rightBracketV2("()[{}]")).isTrue();
        assertThat(lv2.rightBracketV2("[{}]()")).isTrue();
        assertThat(lv2.rightBracketV2(")[{}](")).isFalse();
        assertThat(lv2.rightBracketV2("{}]()[")).isFalse();
    }

    @Test
    public void discountEvent() throws Exception {
        assertThat(lv2.discountEvent(
                new String[]{"banana", "apple", "rice", "pork", "pot"} ,
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"})).isEqualTo(3);
    }

    @Test
    public void splitArr() throws Exception {
        assertThat(lv2.splitArr(3,2,5)).contains(3,2,2,3);
        assertThat(lv2.splitArr(4,7,14)).contains(4,3,3,3,4,4,4,4);
    }

    @Test
    public void clothes() throws Exception {
        /*
        String [][] arr = {
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        };
        assertThat(lv2.clothes(arr)).isEqualTo(5);

        String [][] arr2 = {
                {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}
        };
        assertThat(lv2.clothes(arr2)).isEqualTo(3);


        String [][] arr3 = {
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"yellow_hat", "headgear2"}, {"yellow_hat", "headgear2"}
        };

        assertThat(lv2.clothes(arr3)).isEqualTo(13);


        String [][] arr4 = {
            {"a","aa"},
            {"b","aa"},
            {"c","aa"},
            {"aa","bb"},
            {"bb","bb"},
            {"c_c","bb"},
            {"aaa","cc"},
            {"bbb","cc"},
            {"ccc","cc"}
        };

        assertThat(lv2.clothes(arr4)).isEqualTo(63);

        */

        String [][] arr5 = {
                {"a","a"},
                {"b","b"},
                {"c","c"}
        };

        assertThat(lv2.clothes(arr5)).isEqualTo(7);

    }




}