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
    public static class State{
        public TreeNode node;
        public int depth;
        
        public State(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
        public String toString(){
            return String.valueOf(this.node.val);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        State initial = new State(root, 0);
        List<List<Integer>> layers = new ArrayList();
        
        if(root == null)
            return layers;
        
        Deque<State> q = new LinkedList();
        q.add(initial);
        int level = 0;
        
        while(!q.isEmpty()){  
            ArrayList<State> tmp = new ArrayList();
            //System.out.println("level : " + level);
            while(!q.isEmpty())
                tmp.add(q.poll());
            
            for(State s : tmp){
                TreeNode node = s.node;
                int dep = s.depth;
                if( node.left != null)
                    q.add(new State(node.left, dep+1));
                if(node.right != null)
                    q.add(new State(node.right, dep+1));
            }
            
            if(layers.size() <= level)
                layers.add(new ArrayList<Integer>());
            
            ArrayList<Integer> layer = (ArrayList<Integer>) layers.get(level);
            
            if(level%2==0){
                for(int i = 0; i< tmp.size(); i++){
                   // System.out.println(tmp.get(i).node.val+", ");
                    layer.add(tmp.get(i).node.val);
                }
                
            }else{
                for(int i = tmp.size()-1; i>=0 ;i--){
                    //System.out.println(tmp.get(i).node.val+", ");
                    layer.add(tmp.get(i).node.val);
                }
            }
            
            level ++;
        } 
        return layers;
    }
}
/*
        1
    2           3
4                   5

*/