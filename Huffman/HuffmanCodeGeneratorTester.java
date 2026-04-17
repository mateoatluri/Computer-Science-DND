public class HuffmanCodeGeneratorTester {
    
    public static void main(String[] args) {
        HuffmanCodeGenerator newThing = new HuffmanCodeGenerator("ABCDEFG.txt");

        //System.out.println(HuffmanCodeGenerator("ABCDEFG.txt"));

        System.out.println(newThing.getFrequency('A'));
    }
}
