public class MarkovPredictorTester {
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            System.out.println(MarkovPredictor.predictNextState("Sunny", "weather.csv"));
            
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(MarkovPredictor.predictNextState("Sleeping", "activites.csv"));
            
        }
    }
}
