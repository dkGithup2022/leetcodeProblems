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
    public boolean isSymmetric(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> q = new LinkedList(); // 
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<TreeNode> copyLayer = new ArrayList();
            
            while(!q.isEmpty())
                copyLayer.add(q.poll());
            
            //System.out.println(spread(copyLayer));
            if(! isSymmetric(copyLayer))
                return false;
            
            for( TreeNode node : copyLayer){
                if(node == null)
                    continue;
                if(node.left!= null)
                    q.add(node.left);
                else 
                    q.add(null);
                if(node.right!=null)
                    q.add(node.right);
                else 
                    q.add(null);
            }  
        }
        return true;

    }
    
    private boolean isSymmetric(ArrayList<TreeNode> cl){
        for(int i= 0, j = cl.size() -1 ; i<=j ; i++, j-- ){
            TreeNode ln = cl.get(i);
            TreeNode rn = cl.get(j);
            if(ln==null && rn != null)
                return false;
            if(ln!=null && rn == null)
                return false;
            if( ln == null && rn == null)
                continue;
            if(ln.val != rn.val)
                return false;
        }
        return true;
    }
    
    private String spread(ArrayList<TreeNode> cl ){
        String res= "";
        for(TreeNode n : cl){
            res += n != null ? n.val : "null";
            res += ", ";
        }
        return res;
    }
}