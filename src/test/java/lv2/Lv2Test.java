package lv2;

import lv0.Lv0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class Lv2Test {
    Lv2 lv2 = new Lv2();


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

}