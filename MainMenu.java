package LyricsPlayerv2;
import java.util.*;
import java.io.*;

/**
* The MainMenu class presents the user with Playlist options.  The user may view the current contents
* of the Song Library -- which includes all songs available for playlist inclusion.  The user may also (i) view
* the current contents of a user-defined custom playlist, (ii) add a song from the Song Library to the custom
* playlist, (iii) delete a song from the user's current playlist, (iv) reorder the songs in the current playlist,
* and (v) launch the lyrics playlist -- which outputs relevant information AND lyrics for each song in the
* playlist.  Finally, the user has the option to exit the program.  After each main menu selection (except
* 'EXIT') the user returns to the main menu of options.
* 
* @author Shadiyah Mangru
* @version 1.0
* @since June 2018
*/

public class MainMenu{

	private SongLib theLib;
	private PlayList makeList;
	private BufferedReader reader;
	
	/**
	* No-argument constructor loads the playlist options menu
	*/
	public MainMenu(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		theLib = new SongLib();
		makeList = new PlayList();
		userOptions();
	}
	
	/**
	* a method that outputs a menu with options to view Song Library, create a custom playlist, and EXIT.
	*/
	public void userOptions(){
		System.out.println("\n***********  WELCOME TO LYRICS PLAYER  ***********");
		System.out.println("\nMake a choice:\n1.) View Current Song Library\n2.) View Current PlayList" +
			"\n3.) Add a Song to PlayList\n4.) Delete A Song from PlayList\n5.) Reorder Songs in PlayList\n6.) Create Lyrics PlayList\n\n7.) Exit");
		System.out.println("\n*****************************************************");
		
		try{
			System.out.print("Enter number of selection: ");
			int userChoice = Integer.parseInt(reader.readLine());	
				switch(userChoice){
					case 1: System.out.println("You selected: View Current Song Library\n");
						printLib();
						userOptions();
						break;
					case 2: System.out.println("You selected: View Current PlayList");
						printPlayList();
						userOptions();
						break;
					case 3: System.out.println("You selected: Add a Song to PlayList");
						printLib();
						System.out.print("\nEnter number of song to add to your playlist:  ");
						int addChoice = Integer.parseInt(reader.readLine());
						makeList.getPlayList().add(theLib.alphaSongLib().get(addChoice-1));
						System.out.println(theLib.alphaSongLib().get(addChoice-1).formatInfo() + " successfully added to playlist.");
						userOptions();
						break;
					case 4: System.out.println("You selected: Delete a Song from PlayList");
						printPlayList();
						System.out.print("\nEnter number of song to delete from your playlist:  ");
						int delChoice = Integer.parseInt(reader.readLine());
						String delSong = makeList.getPlayList().get(delChoice-1).formatInfo();
						makeList.getPlayList().remove(delChoice-1);
						System.out.println(delSong + "successfully deleted from playlist.");
						userOptions();
						break;
					case 5: System.out.println("You selected: Reorder Songs in PlayList");
						printPlayList();
						System.out.print("\nEnter number of song to move");
						int moveChoice = Integer.parseInt(reader.readLine());
						Song switcheroo = makeList.getPlayList().get(moveChoice-1);
						makeList.getPlayList().remove(moveChoice-1);
						System.out.print("\nEnter new number of this song in list");
						int newPosition = Integer.parseInt(reader.readLine());
						makeList.getPlayList().add(newPosition-1, switcheroo);
						userOptions();
						break;
					case 6: System.out.println("You selected: Create Lyrics PlayList");
						printLyricsPL();
						userOptions();
						break;
					case 7: System.out.print("You selected: EXIT");
						System.exit(0);
						break;
					default: userOptions(); //reload menu bc invalid selection
						break;	
				}
		}
		catch(Exception e){
		System.out.println("Exception: " + e + "\nTry again!");
		userOptions();
		}
		
	}
	
	/**
	* a method that prints all contents of the Song Library.  these are sorted alphabetically by artist
	*/
	public void printLib(){
		for(int i = 0; i < theLib.alphaSongLib().size(); i++){
			System.out.println((i+1) + ".) " + theLib.alphaSongLib().get(i).formatInfo());	
		}
	}
	
	/**
	* a method that prints identifiers (artist / song / length) for all current contents of the user's playlist
	*/
	public void printPlayList(){
		if(makeList.getPlayList().size()==0){
			System.out.println("Your PlayList is currently empty");
		}
		else{
			for(int i = 0; i< makeList.getPlayList().size(); i++){
				System.out.println((i+1) + ".) " + makeList.getPlayList().get(i).formatInfo());
			}
		}
	}
	
	/**
	* a method that prints identifiers and lyrics for all current contents of the user's playlist
	*/
	public void printLyricsPL(){
		if(makeList.getPlayList().size()==0){
			System.out.println("Your PlayList is currently empty");
		}
		else{
			for(int i = 0; i< makeList.getPlayList().size(); i++){
				System.out.println((i+1) + ".) " + makeList.getPlayList().get(i).formatInfo());
				System.out.println(makeList.getPlayList().get(i).getLyrics()+ "\n");
			}
		}
	}

	/**
	* a method that launches the Lyrics Player v2.0 application
	* @param args command line arguments
	*/
	public static void main(String[] args){
		MainMenu go = new MainMenu();	
	}

}