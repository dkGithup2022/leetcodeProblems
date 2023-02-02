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
        
        // l1 뒤집힌 문자열 
        StringBuilder sb1 = new StringBuilder();
        ListNode node = l1;
        while(node != null){
            sb1.append(node.val);
            node = node.next;
        }
        String s1 = sb1.reverse().toString();
        
        // L2 뒤집힌 문자열 
        StringBuilder sb2 = new StringBuilder();
        node = l2;
        while(node != null){
            sb2.append(node.val);
            node = node.next;
        }
        String s2 = sb2.reverse().toString();
          
        int i1 = s1.length()-1;
        int i2 = s2.length()-1;
        int adder = 0;
        String result = "";
        
        //뒤집힌 숫자의 문자열 덧셈 
        while( !(i1== -1 && i2 == -1)){
            // 삼항 연산자와 while 조건의 조합 ... 이건 solution 보고 알았음 .
            int n1 = i1 == -1 ? 0 : s1.charAt(i1--) - '0' ;
            int n2 = i2 == -1 ? 0 : s2.charAt(i2--) - '0' ;
            int tmpSum = n1 + n2 + adder;
            int cur = tmpSum %10;
            adder = tmpSum/10;
            result = cur +  result ;
        }
        //자투리 숫자 더하기 
        if(adder != 0)
            result = adder + result;
        
        //다시 뒤집기 .
        int ri = result.length() -1;
        ListNode head = new ListNode(result.charAt(ri--)-'0');
        ListNode cursor = head;
        while(ri != -1){
            ListNode tmpNode = new ListNode(result.charAt(ri--)-'0');
            cursor.next = tmpNode;
            cursor = cursor.next;
        } 
        
        return head;
    }
}
