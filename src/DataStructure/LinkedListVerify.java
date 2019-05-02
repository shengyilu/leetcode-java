package DataStructure;

public class LinkedListVerify {

    public void create() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        int[] values = {2, 3, 4, 1, 4, 5};

        for (int value : values) {
            list.add(value);
        }

        // Print all

        System.out.println(list.get(3));
    }

}
