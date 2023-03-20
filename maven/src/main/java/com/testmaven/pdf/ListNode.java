package com.testmaven.pdf;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l4 = new ListNode();
        ListNode tmp = l4;
        int carry = 0;
        while(null!=l1 || null!=l2){
            ListNode l3 = new ListNode();
            int l1val = l1.val;
            int l2val = l2.val;
            int sumVal = l1val + l2val + carry;
            carry = sumVal/10;
            l3.val = sumVal%10;
            l1 = l1.next;
            l2 = l2.next;
            tmp.next = l3;
            tmp = l3;
        }
        return l4.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l3 = new ListNode();
        ListNode l4 = new ListNode();
        ListNode l5 = new ListNode();
        ListNode l6 = new ListNode();
        ListNode l7 = new ListNode();
        l1.val=2;
        l2.val=4;
        l3.val=3;
        l1.next=l2;
        l2.next=l3;
        l4.val=5;
        l5.val=6;
        l6.val=4;
        l4.next = l5;
        l5.next = l6;
        ListNode l8 = addTwoNumbers(l1,l4);
        while(l8!=null){
            System.out.println(l8.val);
            l8 = l8.next;
        }
    }
}