package by.IBA.task;

import java.util.regex.Pattern;

/**
 * There are checked methods for keys.
 */
public class CheckKeys {
    private static Pattern pattern = Pattern.compile("");

    public static boolean checkF(String key){
        pattern = Pattern.compile("^-f");
        return pattern.matcher(key).matches();
    }

    public static boolean checkCMD(String key){
        pattern = Pattern.compile("^-cmd");
        return pattern.matcher(key).matches();
    }

    public static boolean checkRK(String key){
        pattern = Pattern.compile("^-rk");
        return pattern.matcher(key).matches();
    }

}
