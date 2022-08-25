package leetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Leet142_LinkedList_with_cycleTest {

    @Test
    public void defaultData1(){
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2); //the cycle starts here
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        Leet142_LinkedList_with_cycle cycleFinder = new Leet142_LinkedList_with_cycle();
        ListNode myCycleStart = cycleFinder.detectCycle(head);

        assertEquals(second, myCycleStart);
    }

  @Test
    public void defaultData2(){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);

        head.next = second;
        second.next = head;


        Leet142_LinkedList_with_cycle cycleFinder = new Leet142_LinkedList_with_cycle();
        ListNode myCycleStart = cycleFinder.detectCycle(head);

        assertEquals(head, myCycleStart);
    }

    @Test
    public void defaultData3(){
        ListNode head = new ListNode(1);

        Leet142_LinkedList_with_cycle cycleFinder = new Leet142_LinkedList_with_cycle();
        ListNode myCycleStart = cycleFinder.detectCycle(head);

        assertNull(myCycleStart);
    }

    @Test
    public void noCycle(){
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;


        Leet142_LinkedList_with_cycle cycleFinder = new Leet142_LinkedList_with_cycle();
        ListNode myCycleStart = cycleFinder.detectCycle(head);

        assertNull(myCycleStart);
    }
}