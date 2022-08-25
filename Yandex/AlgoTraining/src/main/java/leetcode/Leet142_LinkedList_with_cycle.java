/*
https://leetcode.com/problems/linked-list-cycle-ii/

142. Linked List Cycle II
Given the head of a linked list, return the node where the cycle begins.
If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list
that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node
that tail's next pointer is connected to (0-indexed).
It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
*/

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet142_LinkedList_with_cycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode current = head;
        Set<ListNode> visitedNodes = new HashSet<>();
        visitedNodes.add(current);

        while (current.next != null){
            current = current.next;
            if (visitedNodes.contains(current)){
                return current;
            } else {
                visitedNodes.add(current);
            }
        }
        return null;
    }
}
