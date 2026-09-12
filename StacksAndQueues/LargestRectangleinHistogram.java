package StacksAndQueues;

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static  int largestRectangleArea(int[] heights) {
        return helper(heights);
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
}
