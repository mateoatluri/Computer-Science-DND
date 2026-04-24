import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



public class HuffmanCodeGenerator {


    private HashMap<Character, Integer> frequencies;
    private FrequencyNode root;

    public HuffmanCodeGenerator(String frequencyFile) {
        frequencies = new HashMap<Character, Integer>();
        getFrequencies(frequencyFile);
        root = createTree();
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

}