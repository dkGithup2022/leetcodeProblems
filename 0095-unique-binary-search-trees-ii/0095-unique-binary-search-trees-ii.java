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
    ArrayList<ArrayList<Integer>> orders = new ArrayList();
    String ps = "";
    public List<TreeNode> generateTrees(int n) {
        Set<Integer> used = new HashSet();
        Set<String> dupTree = new HashSet();
        btrk(used, new ArrayList<Integer>(), n );
        System.out.println(orders);
        List<TreeNode> answer = new ArrayList();

        for( ArrayList<Integer> order: orders){
            TreeNode head = build(order);
            String spreaded = spread(head);

            if( dupTree.contains(spreaded))
                continue;
            dupTree.add(spreaded);
            answer.add(head);
        }

        System.out.println("answer : " + answer );
        return answer;
    }

    private TreeNode build(ArrayList<Integer> order){
        TreeNode head = new TreeNode(order.get(0));
        for(int i =1; i<order.size(); i++){
            int num = order.get(i);
            push(head,num);
        }
        return head;
    }

    private String spread( TreeNode node){
        //bfs
        String spreaded = "";
        Queue<TreeNode> q = new LinkedList();
        TreeNode initial = node;

        q.add(initial); 
        spreaded += node.val;

        while(!q.isEmpty()){
            TreeNode current = q.poll();
            
            if(current.left == null){
                spreaded += "n";
            }else{
                spreaded += current.left.val;
                q.add(current.left);
            }

            if(current.right == null){
                spreaded += "n";
            }else{
                spreaded += current.right.val;
                q.add(current.right);
            }
        }

        return spreaded;

    }

    private void push(TreeNode node , Integer num){
        if(node.val > num){
            if(node.left == null){
                node.left= new TreeNode(num);
                return;
            }else{
                push(node.left, num);
            }

        }else{
            if(node.right == null){
                node.right = new TreeNode(num);
                return;
            }else{
                push(node.right, num);
            }
        }
    }

    private void btrk(Set<Integer> used, ArrayList<Integer> current, int n){
        if(n == used.size() ){
            ArrayList<Integer> copy =  (ArrayList<Integer>) current.stream().collect(Collectors.toList());
            orders.add(copy);
            return;
        }

        for(int i = 1 ; i <= n ; i++ ){
            if(used.contains(i))
                continue;
            
            used.add(i);
            current.add(i);
            btrk(used, current, n );
            used.remove(i);
            current.remove((int) current.size() - 1);
        }
        
    }
}