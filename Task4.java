public class Task4 {
    public static void main(String[] args) {
        System.out.println(nonRepeat("abcdabcdbcdbcbc", 0));
    }

    public static String nonRepeat(String s, int startIndex) {
        int count = 0;
        String newStr = "";
        char c = s.charAt(startIndex);
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) count++;
            else newStr += s.charAt(i);
        }
        System.out.println(s + "  " +  c + "  " + count + "  " + startIndex);
        if (count > 3) return nonRepeat(newStr, 0);
        else {
            if (s.length() - 1 == startIndex) return s;
            else return nonRepeat(s, startIndex + 1);
        }
    }
}