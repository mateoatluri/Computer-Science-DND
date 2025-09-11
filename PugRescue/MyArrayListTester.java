import java.util.ArrayList;

public class MyArrayListTester {
    public static void main(String[] args) {
        //ArrayList<String> newList = new ArrayList<String>();
        // newList.add("Mateo");
        // newList.add("Shiv");
        // System.out.println(newList.size());
        // //newList.add(null);
        // System.out.println(newList.size());
        // System.out.println(newList.contains(null));
        //newList.set(6, "shiv");
        //newList.add(4, "hi");
        //newList.add(5, "hello");
        //newList.remove(1);

        MyArrayList<String> myList = new MyArrayList<String>();
        myList.add("Mateo");
        myList.add(null);
        myList.add("Shiv");
        myList.add("hi");
        System.out.println(myList.contains(null));
        System.out.println(myList.toString());

    }
}
