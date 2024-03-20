package stringmatching;

public class FiniteAutomata {
    private static final int NO_OF_CHARS = 256;

    private static int getNextState(String pattern, int state, int x) {
        if (state < pattern.length() && x == pattern.charAt(state)) {
            return state + 1;
        }

        int nextState;
        for (nextState = state; nextState > 0; nextState--) {
            if (pattern.charAt(nextState - 1) == x) {
                int i;
                for (i = 0; i < nextState - 1; i++) {
                    if (pattern.charAt(i) != pattern.charAt(state - nextState + 1 + i)) {
                        break;
                    }
                }
                if (i == nextState - 1) {
                    return nextState;
                }
            }
        }

        return 0;
    }

    public static void search(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();

        int[][] transitionTable = new int[patternLength + 1][NO_OF_CHARS];

        for (int state = 0; state <= patternLength; state++) {
            for (int x = 0; x < NO_OF_CHARS; x++) {
                transitionTable[state][x] = getNextState(pattern, state, x);
            }
        }

        int currentState = 0;
        for (int i = 0; i < textLength; i++) {
            currentState = transitionTable[currentState][text.charAt(i)];
            if (currentState == patternLength) {
                System.out.println("Pattern found at index " + (i - patternLength + 1));
            }
        }
    }
}
