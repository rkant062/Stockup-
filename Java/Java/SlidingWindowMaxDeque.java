package Java;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaxDeque {
    public static void main(String[] args) {
        int[] nums = {1,2,0,3,4,5,6};
        for(int i : maxSlidingWindow(nums, 3)){
                System.out.println(i);
        }
    }
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int l =0; int r=0;

        while(r < n){
            while(!q.isEmpty() && nums[q.peekLast()]< nums[r])
            {
                q.pollLast();
            }
            q.offer(r);

            if(l > q.peekFirst())
            {
                q.pollFirst();
            }

            if(r+1 >= k ) {
                output[l] = nums[q.peekFirst()];
                l++;
            }
            r++;

        }

        return output;



    }
}
