public static int linearSearch(int [] arr, int target){
    if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Array must not be empty");
        }   
    for(int i=0;i<arr.length;i++){
        if(arr[i]==target){
            return i;
        }
    }
    return -1;
}
//Time complexity is O(n) and space complexity is O(1).
//Works on  unsorted array