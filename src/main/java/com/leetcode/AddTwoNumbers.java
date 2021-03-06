package com.leetcode;

/**
 * 给定两个链表分别代表两个非负整数，链表的每个结点分别存储整数的每位数字，且是逆序存储，即：数字最低位存储在链表表头，数字最高位存储在链表表尾。求解这两个整数的和并以相同的链表形式返回计算的结果。
 *
 * 例如：   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)   输出：7 -> 0 -> 8
 */
public class AddTwoNumbers {

	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode{" +
					"val=" + val +
					'}';
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	public String print(ListNode listNode){
		return print(listNode,"");
	}
	public String print(ListNode listNode,String str){
		str+=listNode.val+"->";
		if (listNode.next!=null){
			return print(listNode.next,str);
		}else {
			return str.substring(0,str.length()-2);
		}
	}
	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode n1 = addTwoNumbers.new ListNode(2);
		n1.next=addTwoNumbers.new ListNode(4);
		n1.next.next=addTwoNumbers.new ListNode(3);
		ListNode n2 = addTwoNumbers.new ListNode(5);
		n2.next=addTwoNumbers.new ListNode(6);
		n2.next.next=addTwoNumbers.new ListNode(4);
		ListNode n3 = (addTwoNumbers.addTwoNumbers(n1,n2));
		System.out.println(addTwoNumbers.print(n3));
	}
}
