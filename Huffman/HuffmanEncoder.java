import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {

    private HashMap<Character, String> dictionary;

    public HuffmanEncoder(String codeFile) {

        dictionary = new HashMap<Character, String>();

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(codeFile));
            //PrintWriter pw = new PrintWriter(codeFile + ".huff");

    
            int count = 0;
            String binary = "";
            char currentChar;
    
            while (br.ready()) {
                currentChar = (char) br.read();
                
                
                if (currentChar == (char) '\n') {
                    if (!binary.equals("")) {
                        dictionary.put((char) count, binary);

                        binary = "";
                    }
                    count++;
                } else {
                    binary += currentChar;
                }
    
            }
    
            br.close();
    
            //pw.write(toReturn.toString());
    
            //pw.close();
        } catch (Exception e) {
            System.out.println("Uh oh.");
        }
    }

    public String encodeChar(char input) {

        if (dictionary.get(input) == null) {
            return "";
        } else {
            return dictionary.get(input);
        }

    }

    public void encodeFileToHuffmanCodes(String fileToCompress, String encodedFile) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileToCompress));
            PrintWriter pw = new PrintWriter(encodedFile);

            int totalCharacters = 0;
            char currentChar;

            while (br.ready()) {

                currentChar = (char) br.read();

                String binaryCode = encodeChar(currentChar);
                pw.write(binaryCode);
                totalCharacters += binaryCode.length();

            }

            String endOfFile = encodeChar((char) 26);
            pw.write(endOfFile);

            totalCharacters += endOfFile.length();

            int neededNums = ((8 - (totalCharacters % 8)) % 8);

            for (int i = 0; i < neededNums; i++) {
                pw.write("0");
            }

            br.close();
            pw.close();

        } catch (Exception E) {
            System.out.println("Oopsies! No work :(");
        }
        
        

        

    }
    
}