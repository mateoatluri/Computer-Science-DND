

public class hashFunction {

    String[] names;

    public hashFunction(String[] nameList) {
        names = nameList;
    }


    public static int hashFn(String name) {
        String newName = name.toLowerCase().strip();
        int toReturn = 0;



        for (int i = 0; i < newName.length(); i++) {
            int currentNum = ((int) newName.charAt(i));
            if (!(currentNum == 32)) {
                if (i % 2 == 0) {
                    toReturn = (toReturn * 37) + (currentNum - 97);
                } else if (i % 2 == 1) {
                    toReturn = (toReturn / 39) + (currentNum - 97);
                }
                
            }
            
        }

        int finalInt = toReturn % 500;
        return finalInt;
        
    }

}