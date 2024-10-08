import java.util.*;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2)); // Output: 4
        System.out.println("Length of the longest substring: " + findLength("araaci", 1)); // Output: 2
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3)); // Output: 5
    }
}
