package StacksAndQueues;

import java.util.Stack;
public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static  int largestRectangleArea(int[] heights) {
        return helperOptimized(heights);
    }
    /**
     * Brute force approach 
     * Time complexity is O(n^2)
     * This won't work well with arrays of large size
     * @param heights
     * @return
     */
    private static  int helper(int[] heights) {
        int area=0;
        int temparea=0;
        for(int i=0;i<heights.length;i++){
            int count=1;
            for(int j=i+1;j<heights.length;j++){
                if(heights[i]>heights[j]){
                    break;
                }
                count++;
            }
            for(int j=i-1;j>=0;j--){
                if(heights[i]>heights[j]){
                    break;
                }
                count++;
            }
            temparea=heights[i]*count;
            area=Math.max(area, temparea);
        }
        return area;
    }
    private static int helperOptimized(int[] heights){
        int n=heights.length;
        int[] nearestLeftSmallest=new int[n],nearestRightSmallest=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            nearestLeftSmallest[i]=(stack.isEmpty())?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]) {
                stack.pop();
            }
            nearestRightSmallest[i]=(stack.isEmpty())?n:stack.peek();
            stack.push(i);
        }
        int area=0;
        for(int i=0;i<n;i++){
            int width=nearestRightSmallest[i]-nearestLeftSmallest[i]-1;
            area=Math.max(area, heights[i]*width);
        }
        return area;
    }
}
