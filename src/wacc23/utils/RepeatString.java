package wacc23.utils;

public class RepeatString {
    public static String repeatString(String str, int n) {
        StringBuilder strBdr = new StringBuilder();
        for (int i = 0; i<n; i++) {
            strBdr.append(str);
        }
        return strBdr.toString();
    }
}
