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
   
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        if (root.right == null && root.left == null){
            return root.val == targetSum;  
        }
        return btrk(root, root.val, targetSum);
    }
    
    public boolean btrk(TreeNode root, int current, int targetSum ){
        if(root.left == null && root.right == null){
            if( current == targetSum ){
                return true;
            }else{
                return false;
            }
        }
        
        boolean res = false;
        if(root.left!= null){
            res = (res ||  btrk(root.left, current + root.left.val, targetSum) );
        }
        
        if( res != true && root.right!= null){
            res = (res || btrk(root.right, current + root.right.val, targetSum) );
        }
        return res;
    }
}