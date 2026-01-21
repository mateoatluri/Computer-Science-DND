public class SinglyLinkedListTester {
    
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();
       
        // System.out.println(myList.isEmpty());
        // System.out.println(myList.size());

        // myList.add(5);
        // myList.add(10);
        // myList.add(15);
        // myList.add(20);

        // System.out.println(myList.isEmpty());
        // System.out.println(myList.size());
        // System.out.println(myList.toString());

        Integer[] intArray = {5, 10, 15, 20};
        SinglyLinkedList<Integer> intLinkedList = new SinglyLinkedList<>(intArray);
        System.out.println(intLinkedList.toString());
        // System.out.println(intLinkedList.size());
        // System.out.println(intLinkedList.isEmpty());

        // System.out.println(intLinkedList.contains(null));
        // System.out.println(intLinkedList.contains(5));
        // System.out.println(intLinkedList.contains(12));

        // System.out.println(intLinkedList.getHead());
        // System.out.println(intLinkedList.getTail());

        intLinkedList.add(25);
        System.out.println(intLinkedList.toString());
        // System.out.println(intLinkedList.remove((Integer) 15));
        // System.out.println(intLinkedList.toString());

        // System.out.println(intLinkedList.remove(3));
        // System.out.println(intLinkedList.toString());

        //System.out.println(intLinkedList.contains(25));

        intLinkedList.set(0, 6);
        System.out.println(intLinkedList.toString());

        intLinkedList.add(5, 30);
        intLinkedList.set(0, 5);
        System.out.println(intLinkedList.toString());



    }
}
