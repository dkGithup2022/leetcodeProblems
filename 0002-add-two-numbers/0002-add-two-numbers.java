/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // The number of nodes in each linked list is in the range [1, 100].
        // ㄴ> 무조건 string 연산 , long 도 100 자리는 안되.
        // 처음 숫자 만드는건 string 이니까 StringBuilder.reverse();
        
        StringBuilder sb1 = new StringBuilder();
        ListNode node = l1;
        while(node != null){
            sb1.append(node.val);
            node = node.next;
        }
        
        String s1 = sb1.reverse().toString();
        
        StringBuilder sb2 = new StringBuilder();
        node = l2;
        while(node != null){
            sb2.append(node.val);
            node = node.next;
        }
        String s2 = sb2.reverse().toString();
        //System.out.println("sb1: " + sb1 + " / sb2 : "+ sb2);
        
        int i1 = s1.length()-1;
        int i2 = s2.length()-1;
        int adder = 0;
        String result = "";
        
        while( i1!= -1 && i2 != -1){
            int n1 = s1.charAt(i1--) - '0' ;
            int n2 = s2.charAt(i2--) - '0' ;
            int tmpSum = n1 + n2 + adder;
            int cur = tmpSum %10;
            adder = tmpSum/10;
            result = cur +  result ;
           // System.out.println("res: " + result);
        }
        
        while( i1!= -1 ){
            int n1 = s1.charAt(i1--) - '0' ;
            int tmpSum = n1 + adder;
            int cur = tmpSum %10;
            adder = tmpSum/10;
            result = cur +  result ;
            //System.out.println("res: " + result);
        }
        
        while(  i2 != -1){
            int n2 = s2.charAt(i2--) - '0' ;
            int tmpSum = + n2 + adder;
            int cur = tmpSum %10;
            adder = tmpSum/10;
            result = cur +  result ;
            //System.out.println("res: " + result);
        }
        
        if(adder != 0)
            result = adder + result;
        
        //System.out.println("res: " + result);
        
        int ri = result.length() -1;
        ListNode head = new ListNode(result.charAt(ri--)-'0');
        ListNode cursor = head;
        
        while(ri != -1){
            ListNode tmpNode = new ListNode(result.charAt(ri--)-'0');
            cursor.next = tmpNode;
            //System.out.println(cursor.val+"->"+cursor.next.val);
             cursor = cursor.next;
        } 
        return head;
    }
}
