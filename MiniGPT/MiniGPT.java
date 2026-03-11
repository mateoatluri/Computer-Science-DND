import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Reader;
import java.lang.StringBuilder;

public class MiniGPT {

	private HashMap<String, ArrayList<Character>> map;

	public MiniGPT(String fileName, int chainOrder) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            
			
			int charAsInt;
			int index = 0;
            // Read until the end of the stream (-1 is returned)
			ArrayList<Character> chars = new ArrayList<>();
			

            while ((charAsInt = reader.read()) != -1) {
                // Cast the integer value to a character
                char character = (char) charAsInt;
                //System.out.print(character);

				chars.add((Character) character);

            }



			for (int i = 0; i < chars.size(); i++) {
				StringBuilder newString = new StringBuilder();
				
				for (int j = 0; j < chainOrder; j++) {
					
					newString.append(chars.get(i + j));
				}

				if (map.containsKey(newString.toString())) {
					map.get(newString.toString()).add(chars.get(i + chainOrder));
				} else {
					ArrayList<Character> list = new ArrayList<Character>();
					list.add(chars.get(i + chainOrder));
					map.put(newString.toString(), list);
				}
				
			}


        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }

	}

	
	public static HashMap<String, ArrayList<String>> readData(String filePath) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            ArrayList<String[]> newString = new ArrayList<String[]>();
            
            while ((line = br.readLine()) != null) {
                newString.add(line.split(","));
            }

            HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

            for (int i = 0; i < newString.size(); i++) {
                String currentDay = newString.get(i)[0];
                String nextDay = newString.get(i)[1];
                    if (map.containsKey(currentDay)) {
                        map.get(currentDay).add(nextDay);
                    } else {
                        ArrayList<String> list = new ArrayList<String>();
                        list.add(nextDay);
                        map.put(currentDay, list);
                    }
                
            }

            return map;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	public static void readFile(String[] args) {
        // Example: Reading from a file. You could also use InputStreamReader 
        // for console input.
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            int charAsInt;
            // Read until the end of the stream (-1 is returned)
            while ((charAsInt = reader.read()) != -1) {
                // Cast the integer value to a character
                char character = (char) charAsInt;
                System.out.print(character);
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

	
	public void generateText(String outputFileName, int numChars) {
		
	}
}
