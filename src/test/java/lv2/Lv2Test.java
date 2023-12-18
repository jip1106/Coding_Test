package lv2;

import lv0.Lv0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pra.OtherExplan;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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


}