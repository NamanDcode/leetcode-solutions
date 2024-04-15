/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int totalSum = 0; 
    
   
    void sumNumbersHelper(TreeNode root, int currentSum) {
        if (root.left == null && root.right == null) {
            totalSum += currentSum * 10 + root.val;
            return;
        }
        currentSum *= 10;
        currentSum += root.val;
        if (root.left != null)
            sumNumbersHelper(root.left, currentSum);
        if (root.right != null)
            sumNumbersHelper(root.right, currentSum);
    }
    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        return totalSum;
    }
}