import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HuffmanCodeGeneratorTester {
    
    public static void main(String[] args) {
        HuffmanCodeGenerator newThing = new HuffmanCodeGenerator("frequencyCountInput.txt");

        HuffmanEncoder newEncoder = new HuffmanEncoder("frequencyCountInput.txt.key");
        newEncoder.encodeFileToHuffmanCodes("frequencyCountInput.txt", "frequencyEncoded.txt");

        //newThing.makeCodeFile("frequencyCountInput.txt");

        //System.out.println(HuffmanCodeGenerator("ABCDEFG.txt"));

        //System.out.println(newThing.getFrequency('A'));

        //System.out.println(HuffmanCodeGeneratorTester.treePrinter(newThing.getRoot()));

        //HuffmanCodeGeneratorTester.treePrinter(newThing.getRoot(), 0);

        //System.out.println(newThing.getBinaryDictionary());

        //System.out.println(newThing.getCode('G'));

        

    }

    public static void treePrinter(FrequencyNode node, int givenDepth) {

        char root = node.getValue();
        
        int rootFreq = node.getFreq();

        for (int i = 0; i < givenDepth; i++) {
            System.out.print("    ");
        }
        System.out.println("{" + root + "}" + " | Freq: " + rootFreq + " | Binary: " + node.getBinary());


        if (node.getChild1() != null) {
            treePrinter(node.getChild1(), givenDepth + 1);
        }

        if (node.getChild2() != null) {
            treePrinter(node.getChild2(), givenDepth + 1);
        }


    }
}
