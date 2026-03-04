import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MarkovPredictor {

    // Please define your own variables and data structures
    //

    private int size;


    public ArrayList<String[]> readData(String filePath) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            ArrayList<String[]> newString = new ArrayList<String[]>();
            
            
            
            while ((line = br.readLine()) != null) {
                newString.add(line.split(","));
            }

            return newString;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // Method to predict the next state given a current state
    public String predictNextState(String currentState) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        


    }

}