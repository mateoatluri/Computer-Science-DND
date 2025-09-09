import java.util.ArrayList;



public class PugSaverTester {
    
    public static void main(String[] args) {
        
        ArrayList<Dog> testList = new ArrayList<Dog>();
        // Dog dog1 = new Dog("dog1", "Golden Doodle");
        // Dog dog2 = new Dog("dog2", "Pig");
        // Dog dog3 = new Dog("dog3", "Fat Doodle");
        // Dog dog4 = new Dog("dog4", "Golden Doodle");
        // Dog dog5 = new Dog("dog5", "Pug");
        // Dog dog6 = new Dog("dog6", "Human");

        
        for (int i = 0; i < 1000000; i++) {
            testList.add(new Dog("Mateo"));
            testList.add(new Dog("Shiv", "Golden Doodle"));
            testList.add(new Dog("Zach"));
            testList.add(new Dog("Jackson", "Golden Dog"));
        }

        // testList.add(new Dog("Zach"));
        // testList.add(new Dog("Zach"));
        // testList.add(new Dog("Zach"));
        // testList.add(new Dog("Shiv", "Golden Doodle"));
        // testList.add(new Dog("Shiv", "Golden Doodle"));
        // testList.add(new Dog("Shiv", "Golden Doodle"));
        // testList.add(new Dog("Shiv", "Golden Doodle"));
        // testList.add(new Dog("Shiv", "Golden Doodle"));
        // testList.add(new Dog("Zach"));
        // testList.add(new Dog("Zach"));
        // testList.add(new Dog("Zach"));




        //System.out.println(testList);
        PugSaver.rescuePugs(testList);
        System.out.println(testList);
  

        //System.out.println(testList.get(2));
    }
}
