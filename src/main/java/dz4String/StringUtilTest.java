package dz4String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmitriy on 8/17/15.
 */
public class StringUtilTest {

    @Test
    public void testCalculateWordsInOneSentence() throws Exception {
        //given
        String s = "uiytuw odifoidf lsdhois sdjhjsh.";

        //when
        int result = StringUtil.calculateWordsInOneSentence(s);

        //then
        assertEquals(4, result);
    }

    @Test
    public void testCalculateWordsStartedWithB() {
        //given
        String s = "biytuw odibfoidf bhfgjhg sdjhjsh.";

        //when
        int result = StringUtil.calculateWordsStartedWithB(s);

        //then
        assertEquals(2, result);
    }

    @Test
    public void testCalculateLettersRKT() {
        //given
        String s = "biytuw odibrfoidf bhfgrtkjhg sdjhkjsh.";

        //when
        int result = StringUtil.calculateLettersRKT(s);

        //then
        assertEquals(6, result);
    }

    @Test
    public void testCalculateSymbols() {
        //given
        String s = "biytuw* odib*rfoidf; bhfgrt:kjhg sdjh:kjsh.";

        //when
        int result = StringUtil.calculateSymbols(s);

        //then
        assertEquals(5, result);
    }

    @Test
    public void testCalculateLengthOfLongestWord() {
        //given
        String s = "biytuw* ib*rfoidfu; bhfgrt:kjhg sdjh:kjsh.";

        //when
        int result = StringUtil.calculateLengthOfLongestWord(s);

        //then
        assertEquals(7, result);
    }

    @Test
    public void testCalculateLengthOfShortestWord() {
        //given
        String s = "biytuw* ib*rfoidfu; bhfgrt:kjhg sdjh:kjsh.";

        //when
        int result = StringUtil.calculateLengthOfShortestWord(s);

        //then
        assertEquals(2, result);
    }

    @Test
    public void testCalculateSymbolsBeforeColon() {
        //given
        String s = "biytuw ibrfo:idfu bhfgrt:kjhg sdjhkjsh.";

        //when
        int result = StringUtil.calculateSymbolsBeforeColon(s);

        //then
        assertEquals(12, result);
    }

    @Test
    public void testFindWordsWithLengthThree() {
        //given
        String s = "biytuw ibrfo dfu bhfgrt jhg sdj hkjsh.";

        //when
        String result = StringUtil.findWordsWithLengthThree(s);

        //then
        assertEquals("dfu jhg sdj", result);
    }

    @Test
    public void testRemoveAsteriskDoubleAllCharacters() {
        //given
        String s = "biy*tuw24 42 : ibrfo dfu *bh.?";

        //when
        String result = StringUtil.removeAsteriskDoubleAllCharacters(s);

        //then
        assertEquals("bbiiyyttuuww2244  4422  ::  iibbrrffoo  ddffuu  bbhh..??", result);
    }

    @Test
    public void testCountMatchesABC() {
        //given
        String s = "abcfjfjf jgjgabckgkg abc kkfab c";

        //when
        int result = StringUtil.countMatchesABC(s);

        //then
        assertEquals(3, result);
    }
    @Test
    public void testCountCharacterKInLastWord() {
        //given
        String s = "abcfjfjf jgjgabckgkg abc kkfab";

        //when
        int result = StringUtil.countCharacterKInLastWord(s);

        //then
        assertEquals(2, result);
    }
}
