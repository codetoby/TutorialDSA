package Week2;

import java.util.HashSet;

public class StringDuplicates {

    public static boolean hasDuplicates(String[] words) {

        HashSet<Integer> hashWords = new HashSet<>();
        
        int n = words.length;

        for (int i = 0; i < n; i++) {
            int hashedWord = hash(words[i]);

            if (hashWords.contains(hashedWord)) {
                return true;
            }
            hashWords.add(hashedWord);

        }

        return false;
    }

    private static int hash(String word) {

        int hash = 0;
        int prime = 31;

        int n = word.length();
        for (int i = 0; i < n; i++) {
            hash += ((hash * prime) + (int) word.charAt(i)) % 100;
        }
        return hash;

    }

    public static void main(String[] args) {
        
        String[] words = {"Gello", "Hello", "EHello", "Bye"};
        System.out.println(hasDuplicates(words));

    }
    
}
