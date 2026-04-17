import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class HuffmanCodeGenerator {


    private HashMap<Character, Integer> frequencies;

    public HuffmanCodeGenerator(String frequencyFile) {
        frequencies = new HashMap<Character, Integer>();
        getFrequencies(frequencyFile);
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

    
    
}