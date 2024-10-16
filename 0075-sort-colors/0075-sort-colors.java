class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        
        // Count the number of red (0), white (1), and blue (2)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                red++;
            } else if (nums[i] == 1) {
                white++;
            } else if (nums[i] == 2) {
                blue++;
            }
        }
        
        // Overwrite the array with the correct number of 0s, 1s, and 2s
        int index = 0;
        for (int i = 0; i < red; i++) {
            nums[index++] = 0; // Place all 0s first
        }
        for (int i = 0; i < white; i++) {
            nums[index++] = 1; // Then all 1s
        }
        for (int i = 0; i < blue; i++) {
            nums[index++] = 2; // Finally all 2s
        }
    }
}
