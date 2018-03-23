package terranceyoung.plugin.terrystoolbox.utils;

public class StringArrayToString {
    public static String convertStringArrayToString(String[] strArr, String delimeter) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(delimeter);
        return sb.substring(0, sb.length() - 1);
    }
}
