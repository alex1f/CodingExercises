/*
https://leetcode.com/problems/merge-two-sorted-lists/

21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
*/

package leetcode;

public class Leet21_merge_linked_lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode startOfMergedList = new ListNode();
        ListNode currentMergedList = startOfMergedList;

        ListNode currentA = list1;
        ListNode currentB = list2;

        while (currentA != null || currentB != null){
            if (currentA == null || (currentB != null && currentB.val < currentA.val)){
                currentMergedList.next = currentB;
                currentB = currentB.next;
            } else {
                currentMergedList.next = currentA;
                currentA = currentA.next;
            }
            currentMergedList = currentMergedList.next;
        }
        return startOfMergedList.next;
    }
}

