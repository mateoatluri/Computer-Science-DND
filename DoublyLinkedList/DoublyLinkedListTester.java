public class DoublyLinkedListTester {
    
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();

        // System.out.println(myList);
        // System.out.println(myList.isEmpty());
        // System.out.println(myList.size());
        // System.out.println(myList.toString());

        myList.add(Nucleotide.A);
        myList.add(Nucleotide.G);
        myList.add(Nucleotide.T);
        //myList.add(Nucleotide.C);
        myList.add(Nucleotide.A);
        // myList.add(Nucleotide.T);

        // System.out.println(myList.isEmpty());
        // System.out.println(myList.size());
        // System.out.println(myList.toString());

        // // System.out.println(myList.contains(Nucleotide.C));
        // // System.out.println(myList.indexOf(Nucleotide.T));

        // myList.remove(Nucleotide.T);
        // System.out.println(myList.toString());

        System.out.println(myList.toString());
        myList.add(0, Nucleotide.C);
        System.out.println(myList.toString());

        
    }
}
