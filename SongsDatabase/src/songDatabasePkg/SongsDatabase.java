package songDatabasePkg;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

/**
 * 
 * @author nabilm.twymanjr.
 * 
 */
public class SongsDatabase{
	private Map<String, Set<String>>genreMap=
			new HashMap<String, Set<String>>();
	/**
	 * Adds song to the set mapped to the genre key.
	 * If key does not exist, then the method will put
	 * a genre/set pairing in genreMap.
	 * @param genre The Genre of the song
	 * @param songTitle The Title of the song
	 */
	public void addSong(String genre, String songTitle){
		if(genreMap.containsKey(genre)) {
			genreMap.get(genre).add(songTitle);
		}else {
			genreMap.put(genre, new HashSet<String>());
			this.addSong(genre, songTitle);
		}
	}
	
	/**
	 * Returns a set of all of the songs in the specified genre
	 * @param genre The specified genre.
	 * @return A set of the songs in the specified genre
	 */
	public Set<String> getSongs(String genre){
		return genreMap.get(genre);
	}
	
	/**
	 * Returns all genres of the specified song
	 * @param songTitle The title of the song
	 * @return All genres of the song specified
	 */
	public String getGenreOfSong(String songTitle){
		String genreList = "";
		Set<String> allGenres = genreMap.keySet();
		Iterator<String> it = allGenres.iterator();
		while(it.hasNext()) {
			String g = it.next();
			if(genreMap.get(g).contains(songTitle)) {
				genreList = genreList +" "+g;
			}
		}
		return genreList;
	}
}
