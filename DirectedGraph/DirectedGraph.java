import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;





public class DirectedGraph {

    private List<String> relationshipList;

    public static List<String> readAllLines() {
        List<String> names = new ArrayList<String>();
         try {
               // Each element is one line from the file
               Path p = Paths.get("names.txt");
                return Files.readAllLines(p);
            } 
            catch (Exception e) {
                System.out.println("Couldn't read file");
                }

            return names;
     }
 
 
    // public DirectedGraph() {
        
    //     relationshipList = readAllLines(names.txt);

    // }
    
    


}