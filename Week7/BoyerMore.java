package Week7;

import java.util.Arrays;

public class BoyerMore {

    private static int[] lastOccurence(String pattern) {

        int[] lastOccurence = new int[256];
        Arrays.fill(lastOccurence, -1);

        for (int i = 0; i < pattern.length(); i++) {
            lastOccurence[(int) pattern.charAt(i)] = i;
        }

        return lastOccurence;
    }

    public static int boyerMoore(String text, String pattern) {
        int[] lastOccurence = lastOccurence(pattern);

        int m = pattern.length();
        int n = pattern.length();
        int i = m - 1;
        int j = m -1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                if (j == 0) {
                    i += m;
                    j = m - 1;
                    return i;
                }
                i--;
                j--;
            } else {
                int lastOccur = lastOccurence[text.charAt(i)];
                i += m - Math.min(j, 1 + lastOccur);
                j = m - 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        String text = "aaaahello";
        String pattern = "hello";
        System.out.println(boyerMoore(text, pattern));
    }
    
}
