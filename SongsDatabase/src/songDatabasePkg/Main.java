package songDatabasePkg;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		//TEST 1. create instance
		System.out.println("TEST 1: CREATE INSTANCE");
		SongsDatabase dataBase = new SongsDatabase();
		
		//TEST 2. add key/value pairs
		System.out.println("TEST 2: ADD KEY VALUE PAIRS. SHOULD ONLY ADD SONG TITLE ONCE PER GENRE");
		System.out.println("\tAdding 'Yours is my Heart Alone' to Genre 'Jazz'");
		dataBase.addSong("Jazz", "Yours is My Heart Alone");
		System.out.println("\tAdding 'Yours is my Heart Alone' to Genre 'Jazz'"); // should only have this title once when printed
		dataBase.addSong("Jazz", "Yours is My Heart Alone");
		System.out.println("\tAdding 'Thriller' to Genre 'Jazz'");
		dataBase.addSong("Jazz", "Thriller");
		System.out.println("\tAdding 'Thriller' to Genre 'Pop'");
		dataBase.addSong("Pop", "Thriller");
		
		//TEST 3. use getSongs()
		System.out.println("TEST 3: USE GETSONGS METHOD");
		System.out.println("\tSongs under 'Jazz':");
		Iterator<String>i = dataBase.getSongs("Jazz").iterator();
		while(i.hasNext()) {
			System.out.println("\t\t"+i.next());
		}
		System.out.println("\tSongs under 'Pop':");
		i = dataBase.getSongs("Pop").iterator();
		while(i.hasNext()) {
			System.out.println("\t\t"+i.next());
		}
		
		//TEST 4. use getGenre()
		System.out.println("TEST 4: USE GETGENREOFSONG. SHOULD PRINT ALL GENRES OF GIVEN SONG");
		System.out.println("\tgenre of 'Yours is My Heart Alone': "+dataBase.getGenreOfSong("Yours is My Heart Alone"));
		System.out.println("\tgenre of 'Thriller': "+dataBase.getGenreOfSong("Thriller"));
	}

}
