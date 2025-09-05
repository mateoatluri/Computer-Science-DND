//import java.util.ArrayList;



public class PugSaverTester {
    
    public static void main(String[] args) {
        
        MyArrayList<Dog> testList = new MyArrayList<Dog>();
        Dog dog1 = new Dog("dog1", "Golden Doodle");
        Dog dog2 = new Dog("dog2", "Pig");
        Dog dog3 = new Dog("dog3", "Fat Doodle");
        Dog dog4 = new Dog("dog4", "Golden Doodle");
        Dog dog5 = new Dog("dog5", "Pug");
        Dog dog6 = new Dog("dog6", "Human");

        testList.add(dog1);
        testList.add(dog2);
        testList.add(dog3);
        testList.add(dog4);
        testList.add(dog5);
        testList.add(dog6);


        System.out.println(testList);
        // PugSaver.rescuePugs(testList);
        System.out.println(testList);
  

        //System.out.println(testList.get(2));
    }
}
