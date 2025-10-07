public class DoublyLinkedListTester {
    
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        DoublyLinkedList secondList = new DoublyLinkedList();

        
        myList.add(Nucleotide.A);
        myList.add(Nucleotide.C);
        myList.add(Nucleotide.G);

        secondList.add(Nucleotide.A);
        secondList.add(Nucleotide.C);
        secondList.add(Nucleotide.G);





        // System.out.println(myList.isEmpty());
        // System.out.println(myList.size());
        // System.out.println(myList.toString());

        // // System.out.println(myList.contains(Nucleotide.C));
        // // System.out.println(myList.indexOf(Nucleotide.T));

        // myList.remove(Nucleotide.T);
        // System.out.println(myList.toString());

        // System.out.println(myList.toString());
        // myList.add(4, Nucleotide.C);
        // System.out.println(myList.toString());

        // System.out.println(myList.toString());
        // System.out.println();
        // System.out.println(secondList.toString());

        // myList.deleteSegment(secondList);
        // System.out.println(myList.toString());

        // System.out.println(myList.toString());
        // System.out.println(myList.size());
        // myList.deleteLastThree();
        // System.out.println(myList.toString());
        // System.out.println(myList.size());

        System.out.println(myList.toString());
        // myList.removeCCCCCCCCGGGGGGGG(myList.getNode(0));
        // System.out.println(myList.toString());

        myList.addSegmentToEnd(secondList);
        System.out.println(myList.toString());

        
    }
}
