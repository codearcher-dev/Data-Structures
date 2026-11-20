package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortLinkedList {

    public ListNode sortList(ListNode head) {
        // 1. Base case: 0 or 1 node
        if (head == null || head.next == null) {
            return head;
        }

        // 2. Find the middle and split the list into two halves
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null; // Sever the left half from the right half

        // 3. Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 4. Merge the sorted halves
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // Offset by 1 so even-length lists split cleanly

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    // Example usage
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        MergeSortLinkedList sorter = new MergeSortLinkedList();
        ListNode sorted = sorter.sortList(head);

        while (sorted != null) {
            System.out.print(sorted.val + (sorted.next != null ? " -> " : ""));
            sorted = sorted.next;
        }
        // Output: 1 -> 2 -> 3 -> 4
    }
}