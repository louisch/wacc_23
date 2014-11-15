package wacc23.utils;

public class RepeatString {
    /**
     * This repeats a string n number of times and returns it.
     * Because I didn't want to use:
     * new String(new char[n]).replace("\0", str);
     *
     * @param str String to be repeated
     * @param n Number of times to repeat str
     */
    public static String repeatString(String str, int n) {
        StringBuilder strBdr = new StringBuilder();
        for (int i = 0; i<n; i++) {
            strBdr.append(str);
        }
        return strBdr.toString();
    }
}
