class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node use karte hain to simplify edge cases (like deleting head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 1: fast ko n+1 steps aage le jao
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 2: fast aur slow ko move karo jab tak fast end tak na pahunch jaye
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 3: delete node
        slow.next = slow.next.next;

        return dummy.next; // new head
    }
}
