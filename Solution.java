package com.example.demo;
import static java.lang.System.lineSeparator;
import static java.lang.System.out;

class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //92 Reverse Linked List II
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        boolean isReverse = false;
        ListNode preNode = null,currentNode = head,tmpNode;
        ListNode startNode = currentNode;
        ListNode beginNode = null,endNode = null;
        int index = 1;
        if(m == n)
            return head;
        while(currentNode != null){
            if(index == m){
                isReverse = true;
                beginNode = preNode;
                endNode = currentNode;
            }else if(index == n){
                endNode.next = currentNode.next;
                currentNode.next = preNode;
                if(beginNode == null){
                    startNode = currentNode;
                }else
                beginNode.next = currentNode;
                break;
            }
            if(isReverse) {
                tmpNode = currentNode.next;
                currentNode.next = preNode;
                preNode = currentNode;
                currentNode = tmpNode;
                if (currentNode == null) {
                    startNode = preNode;
                }
            }else {
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            index++;
        }
        return startNode;
    }

}


