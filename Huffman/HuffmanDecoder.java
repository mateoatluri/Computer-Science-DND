import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class HuffmanDecoder {
    
    private HashMap<String, Character> decodedDictionary;


    public HuffmanDecoder(String codeFile) {

        decodedDictionary = new HashMap<String, Character>();

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
                        decodedDictionary.put(binary, (char) count);

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

    

    public boolean isCode(String binary) {

        return decodedDictionary.containsKey(binary);

    }

    public char decodeChar(String binary) {
        
        return decodedDictionary.get(binary);

    }



    /**
     * @return the decodedDictionary
     */
    public HashMap<String, Character> getDecodedDictionary() {
        return decodedDictionary;
    }



    /**
     * @param decodedDictionary the decodedDictionary to set
     */
    public void setDecodedDictionary(HashMap<String, Character> decodedDictionary) {
        this.decodedDictionary = decodedDictionary;
    }

    public void decodeFileFromHuffmanCodes(String encodedFile, String decodedFile) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(encodedFile));
            PrintWriter pw = new PrintWriter(decodedFile);

            char currentChar;
            String currentBinary = "";
            //boolean isBroken;

            while (br.ready()) {

                currentChar = (char) br.read();
                currentBinary += currentChar;

                if (isCode(currentBinary)) {

                    

                    if (decodeChar(currentBinary) == (char) 26) {
                        break;
                    }

                    pw.write(decodeChar(currentBinary));

                    currentBinary = "";

                }

                //pw.write(binaryCode);
                

            }

            br.close();
            pw.close();

        } catch (Exception E) {
            System.out.println("Oopsies! No work :(");
        }

    }

    public void decodeFile(String encodedFile) {

        // do this next class

        try {

            if (!encodedFile.substring(encodedFile.length() - 4).equals(".huf")) {
                throw new IllegalArgumentException("Needs a .huf!");
            }

            BufferedReader br = new BufferedReader(new FileReader(encodedFile));
            PrintWriter pw = new PrintWriter(encodedFile.substring(0, encodedFile.length() - 4));

            char currentChar;
            String currentBinary = "";
            //boolean isBroken;

            while (br.ready()) {

                currentChar = (char) br.read();
                int charAsInt = (int) currentChar;
                
                //currentBinary += currentChar;

                String binary = Integer.toBinaryString(charAsInt);

                if (charAsInt == (char) 26) {
                    break;
                }

                pw.write(binary);

                // if (isCode(currentBinary)) {

                    

                //     if (decodeChar(currentBinary) == (char) 26) {
                //         break;
                //     }

                //     pw.write(decodeChar(currentBinary));

                //     currentBinary = "";

                // }

                //pw.write(binaryCode);
                

            }

            br.close();
            pw.close();

        } catch (Exception E) {
            System.out.println("Oopsies! No work :(");
        }

    }

}
