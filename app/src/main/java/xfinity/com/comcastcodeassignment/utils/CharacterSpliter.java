package xfinity.com.comcastcodeassignment.utils;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is used to split the text into title and description
 */
public class CharacterSpliter {

    /**
     *
     * @param text check the index of " - " in the text and return the 2 substrings which divided by the " - "
     * @return a String list which contains 2 elements, first element is title, and second is description
     */
    public static List<String> splitTitleDes(String text){
        List<String> res = new ArrayList<>();

        int splitIdx = text.indexOf(" - ");

        if(splitIdx < 0){
            res.add(text);
            res.add(text);
        }else {
            res.add(text.substring(0, splitIdx));
            res.add(text.substring(splitIdx + 3));
        }

        return res;
    }
}
