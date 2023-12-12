package lv2;

import lv0.Lv0;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lv2Test {
    Lv2 lv2 = new Lv2();


    @Test
    @DisplayName("LV2 - makeJadenCaseString")
    public void makeJadenCaseString() throws Exception {
        String s = "3people unFollowed me";

        String findStr = lv2.makeJadenCaseString(s);
        Assertions.assertThat(findStr).isEqualTo("3people Unfollowed Me");

        s = "for the last week";
        findStr = lv2.makeJadenCaseString(s);
        Assertions.assertThat(findStr).isEqualTo("For The Last Week");


        s = "test   test";
        findStr = lv2.makeJadenCaseString(s);
        Assertions.assertThat(findStr).isEqualTo("Test   Test");

        s = "test   test ";
        findStr = lv2.makeJadenCaseString(s);
        Assertions.assertThat(findStr).isEqualTo("Test   Test ");


    }

}