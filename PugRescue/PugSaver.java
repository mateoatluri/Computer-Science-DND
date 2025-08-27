import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		int goldenCounter = 0;

		for (int i = 0; i < list.size(); i++) {
			String breed = list.get(i).getBreed();
		    if (breed.toLowerCase().contains("golden")) {
				Dog temp = list.get(i);


				for (int j = list.size() - goldenCounter; j > 0; j--) {
					if (i > j) {
						break;
					}
					if (!(breed.toLowerCase().contains("golden"))) {
						list.set(i, list.get(j));
						list.set(j, temp);
						goldenCounter++;
					}
				}

				if (i > (list.size() - goldenCounter)) {
					break;
				}
			}
		}
		
		
		
		
		
		
		
		
		//attempt 2, maybe work
		// ArrayList<Dog> notGolden = new ArrayList<Dog>();
		// ArrayList<Dog> golden = new ArrayList<Dog>();
		
		// for (int i = 0; i < list.size(); i++) {
		// 	String breed = list.get(i).getBreed();
		//     if (breed.toLowerCase().contains("golden")) {
		// 		golden.add(list.get(i));
		// 	} else {
		// 		notGolden.add(list.get(i));
		// 	}
		// }
		
		// notGolden.addAll(golden);
		// list = notGolden;

		
		
		//attempt 1 nah
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
