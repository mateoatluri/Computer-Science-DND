import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class MarkovPredictor {

    // Please define your own variables and data structures
    //



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




    // Method to predict the next state given a current state
    public static String predictNextState(String currentState, String filePath) {
        HashMap<String, ArrayList<String>> map = MarkovPredictor.readData(filePath);

        ArrayList<String> list = map.get(currentState);

        int number = (int) (Math.random() * list.size());

        return list.get(number);
        
        

    }

}