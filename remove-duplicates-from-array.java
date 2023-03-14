// Problem: Given a sorted array nums, remove the duplicates in-place such that each element appears only once and return the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.



//The brute force solution uses nested loops to compare each element in the array with every
// other element. If a duplicate is found, we shift all the elements to the left to remove the 
//duplicate. The time complexity of this solution is O(n^2) because of the nested loops.

// Brute Force Solution
// Time Complexity: O(n^2)
// Space Complexity: O(1)


public int removeDuplicates(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (nums[i] == nums[j]) {
                // Shift elements left to remove duplicate
                for (int k = j; k < n - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                n--;
                j--;
            }
        }
    }
    return n;
}


//The two pointers solution uses two pointers, i and j, to keep track of the unique elements. 
//Pointer i starts at the beginning of the array, and pointer j starts at the second element. 
//We loop through the array using j and check if the element at j is different from the element at i. 
//If it is different, we increment i and update the element at i to be the element at j. This way, 
//we remove any duplicates and update the array in place. The time complexity of this solution is O(n), where n is the length of the input array.

// Two Pointers Solution
// Time Complexity: O(n)
// Space Complexity: O(1)
public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++;
            nums[i] = nums[j];
        }
    }
    return i + 1;
}


//The hash set solution uses a hash set to keep track of the unique elements. 
//We loop through the input array and add each element to the hash set. 
//Then we loop through the hash set and update the input array with the unique elements. 
//The time complexity of this solution is O(n), but the space complexity is O(n) because we are using extra space to store the hash set.



// Hash Set Solution
// Time Complexity: O(n)
// Space Complexity: O(n)
public int removeDuplicates(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
        set.add(num);
    }
    int i = 0;
    for (int num : set) {
        nums[i++] = num;
    }
    return set.size();
}
