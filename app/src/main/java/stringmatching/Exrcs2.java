package stringmatching;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Exrcs2 {
    public static void printLongestPrefix(String s, BufferedWriter bw) throws IOException {
        Map<String, Integer> prefixCounts = new HashMap<>();
        int n = s.length();

        for (int len = 1; len < n; len++) { // Change the starting point of the loop to 1
            String prefix = s.substring(0, len + 1);
            int[] lps = computeLPSArray(prefix);

            int i = 0;
            int j = 0;
            while (i < n) {
                if (prefix.charAt(j) == s.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == prefix.length()) {
                    prefixCounts.put(prefix, prefixCounts.getOrDefault(prefix, 0) + 1);
                    j = lps[j - 1];
                } else if (i < n && prefix.charAt(j) != s.charAt(i)) {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i = i + 1;
                    }
                }
            }
        }

        String mostFrequentPrefix = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : prefixCounts.entrySet()) {
            String prefix = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && prefix.length() > mostFrequentPrefix.length())) {
                mostFrequentPrefix = prefix;
                maxCount = count;
            }
        }

        bw.write(mostFrequentPrefix + " - " + maxCount + "\n");
        bw.flush();
    }

    private static int[] computeLPSArray(String prefix) {
        int len = 0;
        int i = 1;
        int[] lps = new int[prefix.length()];
        lps[0] = 0;

        while (i < prefix.length()) {
            if (prefix.charAt(i) == prefix.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
