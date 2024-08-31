import java.util.*; // */
public class KMostFrequent {
    
    private static List<Integer> returnTopK(int arr[], int k)  {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: arr){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = (a, b) -> a.getValue() - b.getValue();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(comparator);
       
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the element with the lowest frequency
            }
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        
        Collections.reverse(result); 
        return result;
    
    }

    private static List<Integer> returnLastK(int arr[], int k)  {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: arr){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = (a, b) -> b.getValue() - a.getValue();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(comparator);
       
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            maxHeap.offer(entry);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the element with the lowest frequency
            }
        }
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().getKey());
        }
        
        Collections.reverse(result); 
        return result;
    
    }

    
    public static void main(String[] args) {
        int arr[] = {1,1,1,1,2,2,2,3,3,3,4};
        int k = 3;
        System.out.println(returnTopK(arr, k));
        System.out.println(returnLastK(arr, k));
    }
}
