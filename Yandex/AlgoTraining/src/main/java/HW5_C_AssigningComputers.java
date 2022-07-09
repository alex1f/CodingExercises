import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HW5_C_AssigningComputers {

    public static void main(String[] args) {
        int[] studentNumbers = null;
        int[] roomCapacities = null;

        //System.out.println("input numbers");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            reader.readLine(); //don't need the first input line since the number of groups and classrooms will be
            // known from the size of their respective arrays

            studentNumbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            roomCapacities = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new RoomAllocator().suggestAllocation(studentNumbers, roomCapacities));
    }

}

class RoomAllocator {
    private static int entityId = 1;

    public String suggestAllocation (int[] studentGroups, int[] rooms){
        Map<Integer, Integer> successfulAssignment = RoomAllocator.calculateMaxGroupAssignment(studentGroups, rooms);

        StringBuilder sb = new StringBuilder();

        sb      .append(successfulAssignment.size())
                .append("\n");


        for (int i = 1; i < studentGroups.length + 1; i++) {
            if (successfulAssignment.containsKey(i)) {
                sb.append(successfulAssignment.get(i));

            } else {
                sb.append("0");
            }

            if (i < studentGroups.length){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static Map<Integer, Integer> calculateMaxGroupAssignment(int[] studentGroups, int[] rooms){
        Group[] groups = generateGroupData(studentGroups);
        Arrays.sort(groups, Comparator.comparing(Group::getStudents).thenComparing(Group::getId));

        Room[] roomData = generateRoomData(rooms);
        Arrays.sort(roomData, Comparator.comparingInt(Room::getCapacity).thenComparing(Room::getId));

        Map<Integer, Integer> groupsToRoomsMap = new HashMap<>();

        int currentRoomIndex = 0;
        for (Group group : groups) {
            for (int j = currentRoomIndex; j < roomData.length; j++) {

                int students = group.getStudents();
                int roomCapacity = roomData[j].getCapacity() - 1; //one spot is taken by the professor

                if (students <= roomCapacity) {
                    groupsToRoomsMap.put(group.getId(), roomData[j].getId());
                    currentRoomIndex = j + 1;
                    break;
                }
            }
        }

        return groupsToRoomsMap;
    }

    private static int getNextId(){
        return entityId++;
    }

    private static Room[] generateRoomData(int [] numbers){
        Room[] rooms = new Room[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            rooms[i] = new Room(getNextId(), numbers[i]);
        }
        entityId = 1;
        return rooms;
    }

    private static Group[] generateGroupData(int [] numbers){
        Group[] groups = new Group[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            groups[i] = new Group(getNextId(), numbers[i]);
        }
        entityId = 1;
        return groups;
    }
}


class Group{
    private final int id;
    private final int students;

    Group(int id, int students){
        this.id = id;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public int getStudents() {
        return students;
    }
}

class Room{
    private final int id;
    private final int capacity;

    public Room(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }
}
