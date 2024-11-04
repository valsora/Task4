import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("1. " + nonRepeat("abracadabra"));
        System.out.println("2. " + Arrays.toString(bruteForce(2, 2)));
        System.out.println("3.1. " + encode(new int[]{0, 31, 28, 10, 29}, "MKIIT"));
        System.out.println("3.2. " + Arrays.toString(decode("MTUCI", "MKIIT")));
        System.out.println("4. " + split("((()))(())()()(()())"));
        System.out.println("5. " + shortHand("vvvvaajaaaaa"));
        System.out.println("6. " + convertToRome(52));
        System.out.println("7. " + uniqueSubstring("12223234333"));
        System.out.println("8. " + labirint(new int[][]{{1, 3, 1}, {1, -1, 1}, {4, 2, 1}}));
        System.out.println("9. " + numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println("10. " + fibString("CCCABDD"));
    }

    public static String nonRepeat(String s) {
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            String newStr = "";
            char ch = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ch) count ++;
                else newStr += s.charAt(j);
            }
            if (count > 3) return nonRepeat(newStr);
        }
        return s;
    }

    public static String[] bruteForce(int n, int k) {
        if (n > k) return new String[0];
        int size = factorial(k) / factorial(k - n);
        String[] str = new String[size];
        int index = 0;
        String word = "";
        for (int j = 0; j < k; j++) {
            for (int l = 0; l < k; l++) {
                for (int m = 0; m < k; m++) {
                    for (int o = 0; o < k; o++) {
                        for (int p = 0; p < k; p++) {
                            word += String.valueOf(j) + String.valueOf(l) + String.valueOf(m) + String.valueOf(o) + String.valueOf(p);
                            word = word.substring(0, n);
                            if ((uniqueChars(word)) && (index == 0 || !str[index - 1].equals(word))) {
                                str[index] = word;
                                if (index == size - 1) return str;
                                index ++;
                                word = "";
                            }
                            word = "";
                        }
                    }
                }
            }
        }
        return str;
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static boolean uniqueChars(String s) {
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char ch = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (ch == s.charAt(j)) count ++;
            }
            if (count > 1) return false;
        }
        return true;
    }

    public static String encode(int[] code, String key) {
        String message = "";
        for (int i = 0; i < code.length; i++) {
            message += (char)(code[i] ^ key.charAt(i));
        }
        return message;
    }

    public static int[] decode(String message, String key) {
        int[] code = new int[message.length()];
        for (int i = 0; i < code.length; i++) {
            int messageChar = message.charAt(i);
            int keyChar = key.charAt(i);
            code[i] = messageChar ^ keyChar;
        }
        return code;
    }

    public static ArrayList<String> split(String s) {
        ArrayList<String> arrayList = new ArrayList<>();
        String subString = "(";
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (count == 0) {
                arrayList.add(subString);
                subString = "";
                count = 0;
            }
            char ch = s.charAt(i);
            if (ch == '(') count += 1;
            else count -= 1;
            subString += ch;
        }
        arrayList.add(subString);
        return arrayList;
    }

    public static String shortHand(String s) {
        String newStr = "";
        char ch = s.charAt(0);
        newStr += ch;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (ch == s.charAt(i)) count ++;
            else {
                if (count > 1) newStr += "*" + count;
                ch = s.charAt(i);
                newStr += ch;
                count = 1;
            }
        }
        if (count > 1) newStr += "*" + count;
        return newStr;
    }

    public static String convertToRome(int n) {
        String rome = "";
        int place = 0;
        while (n != 0) {
            switch (place) {
                case 0:
                    switch (n % 10) {
                        case 1:
                            rome = "I" + rome;
                            break;
                        case 2:
                            rome = "II" + rome;
                            break;
                        case 3:
                            rome = "III" + rome;
                            break;
                        case 4:
                            rome = "IV" + rome;
                            break;
                        case 5:
                            rome = "V" + rome;
                            break;
                        case 6:
                            rome = "VI" + rome;
                            break;
                        case 7:
                            rome = "VII" + rome;
                            break;
                        case 8:
                            rome = "VIII" + rome;
                            break;
                        case 9:
                            rome = "IX" + rome;
                            break;
                        default:
                            break;
                    }
                    break;
                case 1:
                    switch (n % 10) {
                        case 1:
                            rome = "X" + rome;
                            break;
                        case 2:
                            rome = "XX" + rome;
                            break;
                        case 3:
                            rome = "XXX" + rome;
                            break;
                        case 4:
                            rome = "XL" + rome;
                            break;
                        case 5:
                            rome = "L" + rome;
                            break;
                        case 6:
                            rome = "LX" + rome;
                            break;
                        case 7:
                            rome = "LXX" + rome;
                            break;
                        case 8:
                            rome = "LXXX" + rome;
                            break;
                        case 9:
                            rome = "XC" + rome;
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (n % 10) {
                        case 1:
                            rome = "C" + rome;
                            break;
                        case 2:
                            rome = "CC" + rome;
                            break;
                        case 3:
                            rome = "CCC" + rome;
                            break;
                        case 4:
                            rome = "CD" + rome;
                            break;
                        case 5:
                            rome = "D" + rome;
                            break;
                        case 6:
                            rome = "DC" + rome;
                            break;
                        case 7:
                            rome = "DCC" + rome;
                            break;
                        case 8:
                            rome = "DCCC" + rome;
                            break;
                        case 9:
                            rome = "CM" + rome;
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    rome = "M" + rome;
                    break;
                default:
                    break;
            }
            place ++;
            n /= 10;
        }
        return rome;
    }

    public static String uniqueSubstring(String s) {
        String even = "";
        String uneven = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) even += s.charAt(i);
            else uneven += s.charAt(i);
        }
        if (biggestAmountOfRepeat(even) > biggestAmountOfRepeat(uneven)) return "чет";
        else return "нечет";
    }

    public static int biggestAmountOfRepeat(String s) {
        int biggestRepeat = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char ch = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (ch == s.charAt(j)) count ++;
            }
            if (count > biggestRepeat) biggestRepeat = count;
        }
        return biggestRepeat;
    }

    public static ArrayList<String> labirint(int[][] matrix) {
        ArrayList<String> paths = new ArrayList<>(); 
        int startCoord = matrix.length - 1;
        addNodeToPath(paths, matrix, "", startCoord, startCoord);
        int minSum = Integer.MAX_VALUE;
        String minPath = "";
        for (String path : paths) {
            path = path.substring(1);
            int sum = 0;
            for (String node : path.split("-")) {
                sum += Integer.parseInt(node);
            }
            if (sum < minSum) {
                minSum = sum;
                minPath = path;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        if (minSum == Integer.MAX_VALUE) result.add("Прохода нет");
        else {
            result.add(minPath);
            result.add(Integer.toString(minSum));
        }
        return result;
    }

    public static void addNodeToPath(ArrayList<String> paths, int[][] matrix, String path, int iNew, int jNew) {
        if (iNew == 0 && jNew == 0) paths.add(path += "-" + matrix[0][0]);
        path += "-" + matrix[iNew][jNew];
        if (iNew - 1 >= 0 && matrix[iNew - 1][jNew] > 0) addNodeToPath(paths, matrix, path, iNew - 1, jNew);
        if (jNew - 1 >= 0 && matrix[iNew][jNew - 1] > 0) addNodeToPath(paths, matrix, path, iNew, jNew - 1);
    }

    public static String numericOrder(String s) {
        String[] splitted = s.split(" ");
        String[] sortedWords = new String[splitted.length];
        for (int i = 0; i < splitted.length; i++) {
            String indexStr = "";
            String word = "";
            for (int j = 0; j < splitted[i].length(); j++) {
                char ch = splitted[i].charAt(j);
                if ('0' <= ch && ch <= '9') indexStr += ch;
                else word += ch;
            }
            int index = Integer.parseInt(indexStr);
            sortedWords[index - 1] = word;
        }
        String sentence = "";
        for (String string : sortedWords) {
            sentence += string + " ";
        }
        return sentence.trim();
    }

    public static boolean fibString(String s) {
        if ("".equals(s)) return false;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashSet<Character> uniqueCharacters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            uniqueCharacters.add(ch);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (ch == s.charAt(j)) count ++;
            }
            hashMap.put(ch, count);
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Character character : uniqueCharacters) {
            numbers.add(hashMap.get(character));
        }
        Collections.sort(numbers);
        if (numbers.size() == 1) {
            if (numbers.get(0) == 1) return true;
            else return false;
        }
        if (numbers.size() == 2) {
            if (numbers.get(0) == 1 && numbers.get(1) == 1) return true;
            else return false;
        }
        if (numbers.get(0) != 1 || numbers.get(1) != 1) return false;
        for (int i = 2; i < numbers.size(); i++) {
            if (numbers.get(i) != numbers.get(i - 1) + numbers.get(i - 2)) return false;
        }
        return true;
    }
}