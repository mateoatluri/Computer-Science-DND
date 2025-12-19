public class SortedArrayListTester {
    public static void main(String[] args) {
        SortedArrayList<String> testString = new SortedArrayList<>();

        testString.add("eagle");
        testString.add("apple");
        testString.add("car");
        testString.add("banana");
        testString.add("dear");

        System.out.println(testString.toString());

        testString.remove("banana");

        System.out.println(testString.toString());

        System.out.println(testString.contains("dear"));

        System.out.println(testString.max());
        System.out.println(testString.min());
    }
}
