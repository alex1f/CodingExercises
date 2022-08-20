package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Leet206_Reverse_Linked_ListTest {

    @Test
    public void defaultData1(){
        int[] input = {1,2,3,4,5};
        ListNode head = LeetLinkedListUtils.buildLinkedList(input);

        List<Integer> expectedOutput = Arrays.asList(5,4,3,2,1);

        Leet206_Reverse_Linked_List listOperator = new Leet206_Reverse_Linked_List();

        List<Integer> myReversedList = LeetLinkedListUtils.getNodeValues(listOperator.reverseList(head));

        assertEquals(expectedOutput, myReversedList);
    }

    @Test
    public void defaultData2(){
        int[] input = {1,2};
        ListNode head = LeetLinkedListUtils.buildLinkedList(input);

        List<Integer> expectedOutput = Arrays.asList(2,1);

        Leet206_Reverse_Linked_List listOperator = new Leet206_Reverse_Linked_List();

        List<Integer> myReversedList = LeetLinkedListUtils.getNodeValues(listOperator.reverseList(head));

        assertEquals(expectedOutput, myReversedList);
    }

    @Test
    public void defaultData3(){
        ListNode head = null;

        List<Integer> expectedOutput = Collections.emptyList();

        Leet206_Reverse_Linked_List listOperator = new Leet206_Reverse_Linked_List();

        List<Integer> myReversedList = LeetLinkedListUtils.getNodeValues(listOperator.reverseList(head));

        assertEquals(expectedOutput, myReversedList);
    }
}