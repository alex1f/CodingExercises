package leetcode;

public class Leet206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode currentReversed = head;
        ListNode nextReversed;

        ListNode currentOriginal = head;
        ListNode nextOriginal;

        while (currentOriginal.next != null){
            nextOriginal = currentOriginal.next;
            nextReversed = new ListNode(nextOriginal.val, currentReversed);
            currentOriginal = nextOriginal;
            currentReversed = nextReversed;
        }
        head.next = null;
    return currentReversed;
    }
}


