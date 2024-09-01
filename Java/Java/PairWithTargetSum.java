package Java;

import java.util.*;
import java.util.stream.Collectors;

public class PairWithTargetSum {
    public static List<int[]> search(int[] arr, int targetSum) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                list.add(new int[] {arr[left], arr[right]});
            }

            if (currentSum < targetSum) 
            {
                left++; 
            } 
            else 
            {
                right--; 
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<int[]> result = search(new int[] {1, 2, 3, 4, 6, 0, -3}, 5);
        result.stream()
              .map(Arrays::toString)
              .forEach(System.out::println);

        String res = result.stream()
              .map(Arrays::toString)
              .collect(Collectors.joining(", "));

        System.out.println(res);
              
    }
}