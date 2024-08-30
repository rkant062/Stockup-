package Java;
class Lego {

    public static int findMinimumEqualSum(int[] rowA, int[] rowB) {
        int sumA = 0;
        int sumB = 0;
        int zeroCountA = 0;
        int zeroCountB = 0;

        for (int i = 0; i < rowA.length; i++) {
            sumA += rowA[i];
            if (rowA[i] == 0) zeroCountA++;
        }

        for (int j = 0; j < rowB.length; j++) {
            sumB += rowB[j];
            if (rowB[j] == 0) zeroCountB++;
        }

        if (sumA == sumB && zeroCountA == 0 && zeroCountB == 0) {
            return sumA;
        }

        int minSumA = sumA + zeroCountA;
        int minSumB = sumB + zeroCountB;

        int maxSumA = sumA + zeroCountA * 10000;
        int maxSumB = sumB + zeroCountB * 10000;

        if (Math.max(minSumA, minSumB) > Math.min(maxSumA, maxSumB)) {
            return -1;
        }

        for (int s = Math.max(minSumA, minSumB); s <= Math.min(maxSumA, maxSumB); s++) {
            if (canMakeSum(rowA, s - sumA) && canMakeSum(rowB, s - sumB)) {
                return s;
            }
        }

        return -1;
    }

    private static boolean canMakeSum(int[] row, int targetSum) {
        int currentSum = 0;
        for (int num : row) {
            if (num == 0) {
                currentSum += 1; 
            }
        }
        return (currentSum <= targetSum && targetSum <= currentSum + 9999 * zeroCount(row));
    }

    private static int zeroCount(int[] row) {
        int count = 0;
        for (int num : row) {
            if (num == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] rowA = {2, 5, 0, 1, 1};
        int[] rowB = {2, 1, 0, 0};
        System.out.println(findMinimumEqualSum(rowA, rowB)); 
    }
}
