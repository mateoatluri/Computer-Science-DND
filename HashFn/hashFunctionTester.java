public class hashFunctionTester {
    
    public static void main(String[] args) {

        String[] output = new String[500];

        String[] names = {
            "Mateo Atluri",
            "Asher Butan",
            "Xander Cheuk",
            "Taj Clement",
            "Camille Condren",
            "Evan Daneshrad",
            "Felicia Duan",
            "Jake Effress",
            "Zachary Figlin",
            "James Graczyk",
            "David Hadi",
            "Quinn Harris",
            "Jackson Hubbard",
            "Siona Kirschner",
            "Dylan Martin",
            "Morgan Maynard",
            "Yari Milakin",
            "Waller Morton",
            "Andrew Stout",
            "Mattin Tasbihgoo",
            "Andrew Theiss",
            "Carter Tsao",

            "Rose Ananda",
            "Autrin Anousheh",
            "Joshua Bie",
            "Elsa Cheng",
            "Isabel Erlic",
            "Jojo Gott",
            "Connor Jun",
            "Jordan Kay",
            "James Klarin",
            "Judy Law",
            "Grayden Lichtman",
            "Runshi Liu",
            "Juan Lopez",
            "Henry Margolis",
            "Garret Morberg-Nguyen",
            "Kai Nantamanasikarn",
            "Remi O'Dell",
            "Emil Palmer",
            "Jaden Park",
            "Ryder Rufi",
            "Alice Shao",
            "Marco Silvera",
            "Samuel Tabib",
            "Andrew Theiss",
            "Shriya Vishwas",
            "Nick Waller",
            "Vikram Wright",
            "Alex Yang",
            "Ethan You",
            "Lucas Yu",
            "Jack Yuan",
            "Jayden Zepeda",
            "Lawrence Zhao",
            "Michael Zhao",
            "Olivia Zhu"
          };
        
        //System.out.println(hashFunction.hashFn(names[0]));

        for (int j = 0; j < names.length; j++) {
            int nextIndex = hashFunction.hashFn(names[j]);
                if (output[nextIndex] != null) {
                System.out.println("duplicateFound for name: " + names[j] + " at index:" + nextIndex);
        
                output[nextIndex] = names[j];
            }
        }

        for (int i = 0; i < names.length; i++) {

            System.out.println(hashFunction.hashFn(names[i]));


        }

        // int nextIndex = hashFunction.hashFn(names[i]);
        //         if (output[nextIndex] != null) {
        //         System.out.println("duplicateFound for name: " + names[i] + " at index:" + nextIndex);
        
        //         output[nextIndex] = names[i];
        //     }

        

        // for (int i = 0; i < names.length; i++) {
        //     int nextIndex = hashFunction.hashFn(names[0]);

        //     if (names[nextIndex] != null) {
        //         System.out.println("duplicateFound for name: " + names[i] + " at index:" + nextIndex);
        //         }

        //         System.out.println(hashFunction.hashFn(names[i]));
            
        // }
    }
}
