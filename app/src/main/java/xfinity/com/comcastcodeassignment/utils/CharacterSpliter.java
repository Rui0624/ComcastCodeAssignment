package xfinity.com.comcastcodeassignment.utils;

import java.util.ArrayList;
import java.util.List;

public class CharacterSpliter {

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
