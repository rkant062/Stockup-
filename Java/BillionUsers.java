package Java;

public class BillionUsers {
    
    public static int findDaysForBillionUsers(double[] growthRates) {
        double target = 1_0;  // 1 billion users
        int tMin = 0;
        int tMax = 1000;  // A reasonable upper bound for the search
        
        while (tMin < tMax) {
            int tMid = (tMin + tMax) / 2;
            double totalUsers = getTotalUsers(growthRates, tMid);
            
            if (totalUsers >= target) {
                tMax = tMid;  // Look for a smaller t
            } else {
                tMin = tMid + 1;  // Increase t to find the point where we reach 1 billion
            }
        }
        
        return tMin;
    }

    private static double getTotalUsers(double[] growthRates, int t) {
        double totalUsers = 0;
        for (double g : growthRates) {
            totalUsers += Math.pow(g, t);
        }
        return totalUsers;
    }

    public static void main(String[] args) {
        // Example usage:
        double[] growthRates = {1.1, 1.2, 1.3};  // Sample growth rates for different apps
        int days = findDaysForBillionUsers(growthRates);
        System.out.println("Days until we have 1 billion users: " + days);
    }
}
