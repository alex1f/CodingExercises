package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Leet21_merge_linked_listsTest {
    private List<Integer> getNodeValues(ListNode start){
        ArrayList<Integer> values = new ArrayList<>();

        while (start != null){
            values.add(start.val);
            start = start.next;
        }
        return values;
    }

    @Test
    public void defaultData1(){
        ListNode listA = new ListNode(1);
        listA.next = new ListNode(2);
        listA.next.next = new ListNode(4);

        ListNode listB = new ListNode(1);
        listB.next = new ListNode(3);
        listB.next.next = new ListNode(4);

        List<Integer> correctMergedListValues = Arrays.asList(1,1,2,3,4,4);

        Leet21_merge_linked_lists listMerger = new Leet21_merge_linked_lists();
        ListNode startOfMergedList = listMerger.mergeTwoLists(listA, listB);
        List<Integer> myMergedValues = getNodeValues(startOfMergedList);

        assertEquals(correctMergedListValues, myMergedValues);
    }

    @Test
    public void defaultData2(){
        ListNode listA = null;


        ListNode listB = null;

        List<Integer> correctMergedListValues = Collections.emptyList();

        Leet21_merge_linked_lists listMerger = new Leet21_merge_linked_lists();
        ListNode startOfMergedList = listMerger.mergeTwoLists(listA, listB);
        List<Integer> myMergedValues = getNodeValues(startOfMergedList);

        assertEquals(correctMergedListValues, myMergedValues);
    }

    @Test
    public void defaultData3(){
        ListNode listA = null;


        ListNode listB = new ListNode(0);

        List<Integer> correctMergedListValues = Collections.singletonList(0);

        Leet21_merge_linked_lists listMerger = new Leet21_merge_linked_lists();
        ListNode startOfMergedList = listMerger.mergeTwoLists(listA, listB);
        List<Integer> myMergedValues = getNodeValues(startOfMergedList);

        assertEquals(correctMergedListValues, myMergedValues);
    }

    @Test
    public void oneListIsShorter(){
        ListNode listA = new ListNode(1);


        ListNode listB = new ListNode(1);
        listB.next = new ListNode(3);
        listB.next.next = new ListNode(4);

        List<Integer> correctMergedListValues = Arrays.asList(1,1,3,4);

        Leet21_merge_linked_lists listMerger = new Leet21_merge_linked_lists();
        ListNode startOfMergedList = listMerger.mergeTwoLists(listA, listB);
        List<Integer> myMergedValues = getNodeValues(startOfMergedList);

        assertEquals(correctMergedListValues, myMergedValues);
    }

    @Test
    public void oneListIsEmpty(){
        ListNode listA = null;


        ListNode listB = new ListNode(1);
        listB.next = new ListNode(3);
        listB.next.next = new ListNode(4);

        List<Integer> correctMergedListValues = Arrays.asList(1,3,4);

        Leet21_merge_linked_lists listMerger = new Leet21_merge_linked_lists();
        ListNode startOfMergedList = listMerger.mergeTwoLists(listA, listB);
        List<Integer> myMergedValues = getNodeValues(startOfMergedList);

        assertEquals(correctMergedListValues, myMergedValues);
    }
}