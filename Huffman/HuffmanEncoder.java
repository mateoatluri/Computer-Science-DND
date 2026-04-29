import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {

    private HashMap<Character, Integer> dictionary;

    public HuffmanEncoder(String codeFile) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(codeFile));
            PrintWriter pw = new PrintWriter(codeFile + ".huff");
    
   
    
            char currentChar = (char) br.read();
            int count = 1;
            String binaryFreq = "";


    
            while (br.ready()) {
                currentChar = (char) br.read();
                
                
                if (currentChar == (char) '\n') {
                    if (!binaryFreq.equals("")) {
                        dictionary.put(currentChar, count);

                        binaryFreq = "";
                    }
                    count++;
                } else {
                    binaryFreq += currentChar;
                }
    
            }
    
            br.close();
    
            //pw.write(toReturn.toString());
    
            pw.close();
        } catch (Exception e) {
            System.out.println("Uh oh.");
        }



    }
    
}