import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



public class HuffmanCodeGenerator {


    private HashMap<Character, Integer> frequencies;
    private HashMap<Character, String> binaryDictionary;
    private FrequencyNode root;

    public HuffmanCodeGenerator(String frequencyFile) {
        frequencies = new HashMap<Character, Integer>();
        binaryDictionary = new HashMap<Character, String>();
        getFrequencies(frequencyFile);
        root = createTree();
        assignBinary(root);
    }
    

    /**
     * @return the frequencies
     */
    public HashMap<Character, Integer> getFrequencies() {
        return frequencies;
    }


    /**
     * @param frequencies the frequencies to set
     */
    public void setFrequencies(HashMap<Character, Integer> frequencies) {
        this.frequencies = frequencies;
    }


    /**
     * @return the root
     */
    public FrequencyNode getRoot() {
        return root;
    }


    /**
     * @param root the root to set
     */
    public void setRoot(FrequencyNode root) {
        this.root = root;
    }


    public void getFrequencies(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			
			int charAsInt;
			
            // Read until the end of the stream (-1 is returned)
			// ArrayList<Character> chars = new ArrayList<>();
			

            while ((charAsInt = reader.read()) != -1) {
                // Cast the integer value to a character
                char character = (char) charAsInt;
                //System.out.print(character);
                int value = 0;
                if (frequencies.get(character) != null) {
                    value = (int) frequencies.get(character);
                }
                //value = (int) frequencies.get(character);
				frequencies.put(character, value + 1);

            }

            frequencies.put((char) 26, 1);


        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

    public int getFrequency(char c) {

        if (frequencies.get(c) == null) {
            return 0;
        }
        return frequencies.get(c);
    }

    public FrequencyNode createTree() {

        ArrayList<FrequencyNode> sortedArray = frequencySort(frequencies);

        while (sortedArray.size() > 1) {
            int last = sortedArray.size() - 1;
            int almostLast = sortedArray.size() - 2;
            int parentFreq = sortedArray.get(last).getFreq() + sortedArray.get(almostLast).getFreq();

            FrequencyNode parent = new FrequencyNode(parentFreq);
            parent.setChild1(sortedArray.get(last));
            

            parent.setChild2(sortedArray.get(almostLast));
            

            sortedArray.get(last).setParent(parent);
            sortedArray.get(almostLast).setParent(parent);

            sortedArray.remove(last);
            sortedArray.remove(almostLast);
            sortedArray.add(parent);

            Collections.sort(sortedArray);

        }



        //add the root node next

        return sortedArray.get(0);

    }

    @SuppressWarnings("unchecked")
    public ArrayList<FrequencyNode> frequencySort(HashMap<Character, Integer> freq) {

        ArrayList<FrequencyNode> freqArray = new ArrayList<>(freq.size());

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            freqArray.add(new FrequencyNode(entry.getKey(), entry.getValue()));
        }

        Collections.sort(freqArray);
        
        return freqArray;
    }

    public void assignBinary(FrequencyNode node) {

        String currentNode = node.getBinary();

        if (node.getChild1() == null && node.getChild2() == null) {
            binaryDictionary.put(node.getValue(), currentNode);
        }

        if (node.getChild1() != null) {
            node.getChild1().setBinary(currentNode + "0");
            assignBinary(node.getChild1());
        }

        if (node.getChild2() != null) {
            node.getChild2().setBinary(currentNode + "1");
            assignBinary(node.getChild2());
        }

    }

    public String getCode(char c) {
        
        if (binaryDictionary.get(c) == null) {
            return "";
        } else {
            return binaryDictionary.get(c);
        }
    }

    public FrequencyNode getNodeWithValue(FrequencyNode node, char c) {
        if (c == (char) 0) {
            return null;
        }
        
        if (node.getValue() == c) {
            return node;
        } else {
            if (node.getChild1() != null) {
                FrequencyNode leftChild = getNodeWithValue(node.getChild1(), c);
                if (leftChild != null) {
                    return leftChild;
                }

            }

            if (node.getChild2() != null) {
                FrequencyNode rightChild = getNodeWithValue(node.getChild2(), c);
                if (rightChild != null) {
                    return rightChild;
                }        
            }
        return null;
        }

    }

    public void makeCodeFile(String codeFile) {

        try {
            //BufferedReader br = new BufferedReader(new FileReader(codeFile));
            PrintWriter pw = new PrintWriter(codeFile + ".key");

            for (int i = 0; i < 128; i++) {
                pw.write(getCode((char) i));
                pw.write("\n");
            }

            pw.close();


        } catch (Exception E) {
            System.out.println("This failed!");
        }

    }


    /**
     * @return the binaryDictionary
     */
    public HashMap<Character, String> getBinaryDictionary() {
        return binaryDictionary;
    }


    /**
     * @param binaryDictionary the binaryDictionary to set
     */
    public void setBinaryDictionary(HashMap<Character, String> binaryDictionary) {
        this.binaryDictionary = binaryDictionary;
    }

    // this method is more like what EncodeFile (day 6) should end up being
    // public void makeCodeFile(String codeFile) {

    //     try {

    //         BufferedReader br = new BufferedReader(new FileReader(codeFile));
    //         PrintWriter pw = new PrintWriter(codeFile + ".huff");
    
    //         StringBuilder toReturn = new StringBuilder();
    
    //         char currentChar = (char) br.read();
    //         //int count = 1;
    
    //         while (br.ready()) {
    //             currentChar = (char) br.read();
    //             String toAdd = getCode(currentChar);
                
    //             toReturn.append(toAdd);
    
    //         }
    
    //         br.close();
    
    //         pw.write(toReturn.toString());
    
    //         pw.close();
    //     } catch (Exception e) {
    //         System.out.println("Uh oh.");
    //     }



        

    // }

}