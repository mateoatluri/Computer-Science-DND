public class MyBSTTester {
    public static void main(String[] args) {
        
        MyBST<Integer> newTree = new MyBST<Integer>();

        //newTree.getRoot().setValue(10);
        newTree.add(1);
        newTree.add(5);
        newTree.add(3);
        newTree.add(4);


        System.out.println(newTree.toString());

        newTree.remove(1);

        System.out.println(newTree.toString());

        //System.out.println(newTree.max());
    }
}
