import java.io.File;

public class RLECompressionTester {
    
    public static void main(String[] args) {
        
        try {
            File f = new File("words.txt.bw");
            File b = new File("words.txt.bw.rle");
            f.delete();
            b.delete();
            
            RLECompression.bwTransform("words.txt");

            RLECompression.compress("words.txt");

            //RLECompression.invertBWTransform("words.txt.bw.rle");

        } catch (Exception e) {

        }
        
        

    }
}
