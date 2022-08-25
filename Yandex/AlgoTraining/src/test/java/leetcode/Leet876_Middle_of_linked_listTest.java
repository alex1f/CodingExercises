package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Leet876_Middle_of_linked_listTest {

    @Test
    public void defaultData1(){
        int[] input = {1,2,3,4,5};
        ListNode head = LeetLinkedListUtils.buildLinkedList(input);

        List<Integer> correctOutput = Arrays.asList(3, 4, 5);

        Leet876_Middle_of_linked_list middleFinder = new Leet876_Middle_of_linked_list();
        ListNode middle = middleFinder.middleNode(head);
        List<Integer> myResult = LeetLinkedListUtils.getNodeValues(middle);

        assertEquals(correctOutput, myResult);
    }

    @Test
    public void defaultData2(){
        int[] input = {1,2,3,4,5,6};
        ListNode head = LeetLinkedListUtils.buildLinkedList(input);

        List<Integer> correctOutput = Arrays.asList(4, 5, 6);

        Leet876_Middle_of_linked_list middleFinder = new Leet876_Middle_of_linked_list();
        ListNode middle = middleFinder.middleNode(head);
        List<Integer> myResult = LeetLinkedListUtils.getNodeValues(middle);

        assertEquals(correctOutput, myResult);
    }

    @Test
    public void onlyOneNode(){
        int[] input = {6};
        ListNode head = LeetLinkedListUtils.buildLinkedList(input);

        List<Integer> correctOutput = Collections.singletonList(6);

        Leet876_Middle_of_linked_list middleFinder = new Leet876_Middle_of_linked_list();
        ListNode middle = middleFinder.middleNode(head);
        List<Integer> myResult = LeetLinkedListUtils.getNodeValues(middle);

        assertEquals(correctOutput, myResult);
    }

}