package LyricsPlayerv2;
import java.util.*;

/**
* The PlayList class holds current contents of user's custom playlsit (including lyrics!)
* 
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/

public class PlayList{
	private ArrayList<Song> myPlayList;
	
	/**
	* No-argument Constructor
	*/
	public PlayList(){
		setPlayList();
	}
	
	/**
	* a method that initializes a new playlist arraylist
	*/
	public void setPlayList(){
		myPlayList = new ArrayList<Song>();
	}
	
	/**
	* a method to return the current playlist
	* @return ArrayList current playlist
	*/
	public ArrayList<Song> getPlayList(){
		return myPlayList;	
	}
	
}