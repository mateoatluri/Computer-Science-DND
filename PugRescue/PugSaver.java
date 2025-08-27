import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		ArrayList<Dog> notGolden = new ArrayList<Dog>();
		ArrayList<Dog> golden = new ArrayList<Dog>();
		
		for (int i = 0; i < list.size(); i++) {
			String breed = list.get(i).getBreed();
		    if (breed.toLowerCase().contains("golden")) {
				golden.add(list.get(i));
			} else {
				notGolden.add(list.get(i));
			}
		}
		
		notGolden.addAll(golden);
		list = notGolden;

		
		
		
		// for (int i = 0; i < list.size(); i++) {
		// 	String breed = list.get(i).getBreed();
		// 	if (breed.toLowerCase().contains("golden")) {
		// 		Dog puppy = list.get(i);
		// 		list.remove(i);
		// 		list.add(puppy);
		//      i--;
		// 	}
		// }
	}
}
