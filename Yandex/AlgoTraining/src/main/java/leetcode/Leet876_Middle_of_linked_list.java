/*
https://leetcode.com/problems/middle-of-the-linked-list/

876. Middle of the Linked List
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
*/

package leetcode;

public class Leet876_Middle_of_linked_list {
    public ListNode middleNode(ListNode head) {
        int listSize = determineListSize(head);
        ListNode middle = head;

        int middleElementNumber = listSize / 2;

        for (int i = 0; i < middleElementNumber; i++){
            middle = middle.next;
        }

        return middle;
    }

    private int determineListSize(ListNode head){
        int size = 0;
        while (head != null){
            size++;
            if (head.next != null){
                head = head.next;
            } else {
                head = null;
            }
        }
        return size;
    }
}
