import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1L);
        HashSet<Long> set = new HashSet();
        while(set.size() != n){
            long x = q.poll();
            while(!q.isEmpty() && q.peek() == x) 
                q.poll();
            q.add(x*2);
            q.add(x*3);
            q.add(x*5);
            set.add(x);
        }
        
        ArrayList<Long> res = new ArrayList();
        for(long x : set)
            res.add(x);
        Collections.sort(res);
        return res.get(res.size()-1).intValue();
        
        /*
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
        */
    }
}