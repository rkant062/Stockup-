package Java;

import java.util.Arrays;

public class BananaPilesBinarySearch {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;

            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / k);
            }
            if (totalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BananaPilesBinarySearch bsp = new BananaPilesBinarySearch();
        System.out.println(bsp.minEatingSpeed(new int[]{1,2,3,4}, 9) == 2);
        System.out.println(bsp.minEatingSpeed(new int[]{11,12,13,7}, 4) == 13);
    }
}

    
