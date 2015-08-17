package dz4String;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dmitriy on 8/17/15.
 */
public abstract class StringUtil {

    public static int calculateWordsInOneSentence(String s) {
        String string = s.substring(0, s.indexOf("."));
        return string.split(" ").length;
    }

    public static int calculateWordsStartedWithB(String s) {
        int counter = 0;
        Pattern pattern = Pattern.compile("\\b(b[\\w]+)");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    public static int calculateLettersRKT(String s) {
        return calculateMatches(s, 'r', 'k', 't');
    }

    public static int calculateSymbols(String s) {
        return calculateMatches(s, '*', ';', ':');
    }

    public static int calculateLengthOfLongestWord(String s) {
        String[] strings = s.split("\\W");
        int length = 0;

        for (String str : strings) {

            if (length < str.length()) {
                length = str.length();
            }
        }
        return length;
    }

    public static int calculateLengthOfShortestWord(String s) {
        String[] strings = s.split("\\W");
        int length = strings[0].length();

        for (String str : strings) {

            if (str.length() != 0 && length > str.length()) {
                length = str.length();
            }
        }
        return length;
    }

    public static int calculateSymbolsBeforeColon(String s) {
        String string = s.substring(0, s.indexOf(":"));
        return string.length();
    }

    public static String findWordsWithLengthThree(String s) {
        String[] strings = s.split("\\W");
        StringBuilder builder = new StringBuilder();

        for (String str : strings) {

            if (str.length() == 3) {

                if (builder.length() > 0) {
                    builder.append(" ");
                }
                builder.append(str);
            }
        }

        return builder.toString();
    }

    public static String removeAsteriskDoubleAllCharacters(String s) {
        String tmp = s.replaceAll("\\*", "");
        StringBuilder builder = new StringBuilder();

        for (char ch : tmp.toCharArray()) {
            builder.append(ch);
            builder.append(ch);
        }

        return builder.toString();
    }

    public static int countMatchesABC(String s) {
        int counter = 0;
        int startIndex = 0;

        while (s.indexOf("abc", startIndex) != -1) {
            counter++;
            startIndex = s.indexOf("abc", startIndex) + 2;
        }
        return counter;
    }

    public static int countCharacterKInLastWord(String s) {
        int counter = 0;
        String[] strings = s.split("\\W");

        for (char ch : strings[strings.length - 1].toCharArray()) {
            if (ch == 'k') {
                counter++;
            }
        }
        return counter;
    }

    private static int calculateMatches(String s, Character... chars) {
        List<Character> list = Arrays.asList(chars);
        int counter = 0;

        for (char ch : s.toCharArray()) {
            if (list.contains(ch)) {
                counter++;
            }
        }
        return counter;
    }
}
