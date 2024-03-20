package stringmatching;

import java.util.ArrayList;
import java.util.List;

public class Exrcs1 {
    private static final int PRIME = 101;

    public static List<Integer> findPatternOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();
        int patternHash = calculateHash(pattern, m);
        int textHash = calculateHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && checkEquality(text, pattern, i, i + m - 1)) {
                occurrences.add(i);
            }
            if (i < n - m) {
                textHash = recalculateHash(text, textHash, i, i + m, m);
            }
        }

        return occurrences;
    }

    private static int calculateHash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private static int recalculateHash(String str, int oldHash, int oldIndex, int newIndex, int length) {
        int newHash = oldHash - str.charAt(oldIndex);
        newHash /= PRIME;
        newHash += str.charAt(newIndex) * Math.pow(PRIME, length - 1);
        return newHash;
    }

    private static boolean checkEquality(String text, String pattern, int start, int end) {
        for (int i = start, j = 0; i <= end; i++, j++) {
            if (text.charAt(i) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}