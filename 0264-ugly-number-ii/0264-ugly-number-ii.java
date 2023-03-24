import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        /*
        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(1);
        HashSet<Integer> set = new HashSet();
        int mx = 1;
        while(set.size() != n){
            int x = q.poll();
            mx = Math.mx(x,mx);
            q.add(x*2);
            q.add(x*3);
            q.add(x*5);
            set.add(x);
        }
        
        ArrayList<Integer> res = new ArrayList();
        for(int x : set)
            res.add(x);
        Collections.sort(res);
        return res.get(res.size()-1);
        */
        
        if(n==1) return 1;
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1l);

        for(long i=1; i<n; i++) {
            long tmp = q.poll();
            while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

            q.add(tmp*2);
            q.add(tmp*3);
            q.add(tmp*5);
        }
        return q.poll().intValue();
    }
}