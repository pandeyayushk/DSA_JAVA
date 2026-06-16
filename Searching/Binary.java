public int binarySearch(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
        throw new IllegalArgumentException("Array must not be empty");
    }

    int start = 0;
    int end = arr.length - 1;
    boolean isAscending = arr[start] < arr[end]; // detect order

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (isAscending) {
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else { // descending
            if (arr[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
    return -1;
}
//Time complexity is O(log n) and Space complexity is O(1)
//Works on sorted array only
