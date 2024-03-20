package stringmatching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Exercise 1: Pattern Matching using Rabin-Karp Algorithm

        bw.write("Exercise 1: Pattern Matching using Rabin-Karp Algorithm \n");
        bw.write("Enter the Text\n");
        bw.flush();
        String text = br.readLine();
        bw.write("Enter the Pattern\n");
        bw.flush();
        String pattern = br.readLine();
        List<Integer> occurrences = Exrcs1.findPatternOccurrences(text, pattern);
        System.out.println("Pattern occurrences found at indices: " + occurrences);

        // Exercise 2: Pattern Matching using KMP Algorithm

        bw.write("Exercise 2: Pattern Matching using Finite Automata\n");
        bw.write("Enter the String\n");
        bw.flush();
        String s = br.readLine();
        Exrcs2.printLongestPrefix(s, bw);

        // Exercise 3: Pattern Matching using KMP Algorithm

        StringTokenizer st = new StringTokenizer(br.readLine());
        String T = st.nextToken();
        String P = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int[] numbers = new int[x];
        for (int i = 0; i < x; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < x; i++) {
            int longestMatch = Exrcs3.findLongestMatch(T, P, numbers[i]);
            System.out.println(longestMatch);
        }

    }
}
