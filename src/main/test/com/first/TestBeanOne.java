package com.first;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 周云龙
 * @date 2018/4/3 9:58
 */
public class TestBeanOne {

    @Test
    public void test1() {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        applicationContext.registerShutdownHook();
        InitBean initBean = applicationContext.getBean("bean1", InitBean.class);
    }

    @Test
    public void test2() {
//        Assert.isNull(null, "ssss");
//        System.out.println(Math.pow(100, 0));
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.addLast(3);
        linkedList1.addLast(4);
        linkedList1.addLast(2);
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.addLast(4);
        linkedList2.addLast(6);
        linkedList2.addLast(5);
        List<Integer> linkedList3=add(linkedList1,linkedList2);

        linkedList3.forEach(System.out::println);
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param list1
     * @param list2
     * @return
     */
    public List<Integer> add(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        int size1 = list1.size();
        int size2 = list2.size();
        int p1 = 0, p2 = 0;
        for (int i = 0; i < size1; i++) {

            p1 += list1.get(i) * (Math.pow(10, i));
        }

        for (int i = 0; i < size2; i++) {
            p2 += list2.get(i) * (Math.pow(10, i));
        }

        int p3 = p1 + p2;
        int size3 = String.valueOf(p3).length();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size3; i++) {
            //123
            int shang = (int) (p3/(Math.pow(10, size3-i-1)));
            p3= (int) (p3-shang*(Math.pow(10, size3-i-1)));
            linkedList.addLast(shang);
        }


        return linkedList;
    }


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }


            return null;
        }
    }
}
