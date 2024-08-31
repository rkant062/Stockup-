import java.util.*;

class BadgeRecordsAnalyzer {

    public static List<List<String>> analyzeRecords(List<List<String>> badgeRecords) {
        Map<String, Integer> userStatusMap = new HashMap<>();
        Set<String> invalidEntries = new HashSet<>();
        Set<String> invalidExits = new HashSet<>();

        // Iterate through each record
        for (List<String> record : badgeRecords) {
            String name = record.get(0);
            String action = record.get(1);

            if (action.equals("exit")) {
                if (!userStatusMap.containsKey(name) || userStatusMap.get(name) != 1) {
                    invalidEntries.add(name);
                } else {
                    userStatusMap.put(name, 0);  // User has exited
                }
            }

            if (action.equals("enter")) {
                if (!userStatusMap.containsKey(name) || userStatusMap.get(name) == 0) {
                    userStatusMap.put(name, 1);  // User has entered
                } else if (userStatusMap.get(name) == 1) {
                    invalidExits.add(name);
                }
            }
        }

        // After processing all records, check for users still marked as inside
        for (Map.Entry<String, Integer> entry : userStatusMap.entrySet()) {
            if (entry.getValue() == 1) {
                invalidExits.add(entry.getKey());
            }
        }

        // Convert sets to sorted lists
        List<String> invalidEntriesList = new ArrayList<>(invalidEntries);
        List<String> invalidExitsList = new ArrayList<>(invalidExits);
        Collections.sort(invalidEntriesList);
        Collections.sort(invalidExitsList);

        // Prepare result list
        List<List<String>> result = new ArrayList<>();
        result.add(invalidEntriesList);
        result.add(invalidExitsList);

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> badgeRecords = Arrays.asList(
            Arrays.asList("Alice", "enter"),
            Arrays.asList("Alice", "exit"),
            Arrays.asList("Bob", "enter"),
            Arrays.asList("Bob", "enter"),
            Arrays.asList("Carol", "exit")
        );

        List<List<String>> result = analyzeRecords(badgeRecords);

        System.out.println("Invalid Entries: " + result.get(0));
        System.out.println("Invalid Exits: " + result.get(1));
    }
}
