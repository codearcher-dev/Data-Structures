package Backtracking;

import jdk.jshell.spi.SPIResolutionException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNode {
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

public class Solution {

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        prev.next = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverse(ListNode head, int left, int right) {
        ListNode start = head;
        ListNode end = head;
        ListNode dummy = new ListNode(0,head);
        ListNode dummy2 = end.next;

        while (start.next != null) {
            if (start.val == left) {
                break;
            }
            start = start.next;
            dummy = dummy.next;
        }
        while (end.next != null) {
            if (end.val == right) {
                break;
            }
            end = end.next;
            dummy2 = dummy2.next;
        }
        System.out.println(start.val);
        System.out.println(end.val);

        dummy.next = null;
        end.next = null;

        ListNode reversed = reverse(start);

        while (end.next != null){
            end = end.next;
        }

        dummy.next = reversed;
        end.next = dummy2;

        return head;
    }

    public boolean isCycleExist(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    public void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        ListNode head = new ListNode(3, new ListNode(4));

        String ip = "1231231231234";

//        obj.print(head);
        head = obj.reverse(head, 2, 2);
//        System.out.println(obj.isCycleExist(head));
        obj.print(head);
    }
}