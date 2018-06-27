package LyricsPlayerv2;
import java.time.*;

/**
* The Song class provides a template for each Song object.  
* 
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/

public class Song implements Comparable<Song>{
	private String Title ="";
	private String Artist ="";
	private String Lyrics = "";
	private LocalTime SongLength;

	/**
	* a method that defines how to sort Songs alphabetically by artist
	* @param Song the song we are comparing to
	*/
	@Override
    	public int compareTo(Song other) {
    		if (this.getArtist().charAt(0) < other.getArtist().charAt(0)) {
    			return -1;
    		}
    		if (this.Artist == other.Artist) {
    			return 0;
    		}
    		return 1;
    	}
	
	/**
	* Constructor without lyrics
	* @param title of song
	* @param artist of song
	* @param hr part of song length
	* @param min part of song length
	* @param sec part of song length
	*/
	public Song(String title, String artist, int hr, int min, int sec){
		setTitle(title);
		setArtist(artist);
		setLength(hr, min, sec);	
	}
	
	/**
	* Constructor with lyrics
	* @param title of song
	* @param artist of song
	* @param hr part of song length
	* @param min part of song length
	* @param sec  part of song length
	* @param lyrics of song
	*/
	public Song(String title, String artist, int hr, int min, int sec, String lyrics){
		setTitle(title);
		setArtist(artist);
		setLength(hr, min, sec);	
		setLyrics(lyrics);
	}
	
	/**
	* a method to set the title of the current Song object
	* @param Title of song
	*/
	public void setTitle(String Title){
		this.Title = Title;	
	}
		
	/**
	* a method to set the artist of the current Song object
	* @param Artist of song
	*/
	public void setArtist(String Artist){
		this.Artist = Artist;	
	}
		
	/**
	* a method to set the length of the current Song object
	* @param hours part of song length
	* @param minutes part of song length
	* @param seconds part of song length
	*/
	public void setLength(int hours, int minutes, int seconds){
		SongLength = LocalTime.of(hours, minutes, seconds);	
	}
	
	/**
	* a method to set the lyrics of the current Song object
	* @param Lyrics of song
	*/
	public void setLyrics(String Lyrics){
		this.Lyrics = Lyrics;	
	}
		
	/**
	* a method that returns the title of the current Song object
	* @return String title of song
	*/
	public String getTitle(){
		return Title;	
	}
	
	/**
	* a method that returns the artist of the current Song object
	* @return String artist of song
	*/
	public String getArtist(){
		return Artist;	
	}
	
	/**
	* a method that returns the length of the current Song object
	* @return LocalTime song length
	*/
	public LocalTime getLength(){
		return SongLength;	
	}
	
	/**
	* a method that returns the lyrics of the current Song object
	* @return String song lyrics
	*/
	public String getLyrics(){
		return Lyrics;		
	}
		
	/**
	* a method that formats and returns the song's artist, title, and length
	* @return String song's artist, title and length
	*/
	public String formatInfo(){
		return getArtist()+ " / '" + getTitle() + "' / (" + getLength() + ")";	
	}
}