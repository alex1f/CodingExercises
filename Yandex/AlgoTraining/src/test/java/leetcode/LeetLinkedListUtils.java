package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetLinkedListUtils {
    public static List<Integer> getNodeValues(ListNode start){
        ArrayList<Integer> values = new ArrayList<>();

        while (start != null){
            values.add(start.val);
            start = start.next;
        }
        return values;
    }

    public static ListNode buildLinkedList(int[] numbers){
        if (numbers == null){
            return null;
        }
        ListNode head = new ListNode(numbers[0]);
        ListNode current = head;
        for (int i = 1; i < numbers.length; i++){
            ListNode nextNode = new ListNode(numbers[i]);
            current.next = nextNode;
            current = nextNode;
        }
        return head;
    }
}
