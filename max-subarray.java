 
    /**
     * Given an integer array nums, find the contiguous subarray 
     * (containing at least one number) which has the largest sum 
     * and return its sum.
     */
    
    /**
     * Approach 1: Brute Force
     * The brute force solution would be to consider all possible
     * subarrays of the given array and compute their sum. This
     * would take O(n^3) time.
     */
    public static int maxSubArrayBruteForce(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    
    /**
     * Approach 2: Divide and Conquer
     * The divide and conquer approach divides the array into
     * two halves and recursively finds the maximum subarray in
     * each half. The maximum subarray can either lie in the
     * left half, right half, or span both halves. We can find
     * the maximum subarray that spans both halves in O(n) time
     * by starting at the middle of the array and finding the
     * maximum subarray that includes the middle element and
     * expands outwards to include elements from both halves.
     * This algorithm has a time complexity of O(nlogn).
     */
    public static int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSubArrayDivideAndConquerHelper(nums, 0, nums.length - 1);
    }
    
    private static int maxSubArrayDivideAndConquerHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSum = maxSubArrayDivideAndConquerHelper(nums, left, mid);
        int rightSum = maxSubArrayDivideAndConquerHelper(nums, mid + 1, right);
        int crossingSum = maxCrossingSubArray(nums, left, mid, right);
        return Math.max(Math.max(leftSum, rightSum), crossingSum);
    }
    
    private static int maxCrossingSubArray(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }