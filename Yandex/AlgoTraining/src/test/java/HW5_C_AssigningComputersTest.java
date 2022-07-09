import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HW5_C_AssigningComputersTest {

    @Test
    public void defaultData1(){
        //input
        int[] students = {1};
        int[] rooms = {2};

        //expected output
        String expectedResult = "1\n1";

        //my result
        String actualResult = new RoomAllocator().suggestAllocation(students, rooms);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void defaultData2(){
        //input
        int[] students = {1};
        int[] rooms = {1};

        //expected output
        String expectedResult = "0\n0";

        //my result
        String actualResult = new RoomAllocator().suggestAllocation(students, rooms);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void genericData1(){
        //input
        int[] students = {5, 6, 8, 1, 100};
        int[] rooms = {6, 7, 9, 2, 101};

        //expected output
        String expectedResult = "5\n1 2 3 4 5";

        //my result
        String actualResult = new RoomAllocator().suggestAllocation(students, rooms);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void noSuitableRooms(){
        //input
        int[] students = {5, 6, 8, 1, 100};
        int[] rooms = {1, 1, 1, 1, 1};

        //expected output
        String expectedResult = "0\n0 0 0 0 0";

        //my result
        String actualResult = new RoomAllocator().suggestAllocation(students, rooms);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void onlySmallRooms(){
        //input
        int[] students = {5, 6, 100};
        int[] rooms = {6, 7, 6};

        //expected output
        String expectedResult = "2\n1 2 0";

        //my result
        String actualResult = new RoomAllocator().suggestAllocation(students, rooms);

        assertEquals(expectedResult, actualResult);
    }

}