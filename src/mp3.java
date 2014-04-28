import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.farng.mp3.*;
import org.farng.mp3.id3.AbstractID3;


public class mp3 {
	
	private String title;
	private String artist;
	private String version;
	
	private String identifier;
	
	private AbstractID3 id;
	private MP3File mp3; 
	
	public mp3(){
		this.title = null;
		this.artist = null;
		this.version = null;
	}
	
	public mp3(File file) throws Exception{
		this.mp3 = new MP3File(file);
		this.title = getSongName(this.mp3);
		this.artist = getSongArtist(this.mp3);
		this.version = getID3Version();
		setIdentifier();
	}
	
	private String getSongArtist(MP3File mp3) {
		return mp3.getID3v2Tag().getLeadArtist();
	}
	
	public String getSongArtist(){
		return this.artist;
	}

	private String getSongName(MP3File mp3){
		return mp3.getID3v2Tag().getSongTitle();
	}

	public String getSongName(){
		return this.title;
	}
	
	public static void main(String [] args){
		File song = new File("./src/song.mp3");
		try {
			mp3 mp = new mp3(song);
			System.out.println(mp.getSongArtist());
			System.out.println(mp.getSongName());
			System.out.println(mp.getID3Version());
			mp.setSongArtist("50 Tyson");
			mp.setSongName("niggers in the house");
			System.out.println(mp.getSongArtist());
			System.out.println(mp.getSongName());
		} catch (Exception e) {e.printStackTrace();}
	}
	
	//accepts an MP3File as a parameter
	//returns the id3 version if found, else returns -1
	public String getID3Version(){
		if(mp3.hasID3v1Tag()){
			this.id = mp3.getID3v1Tag();
			return "id3v1";
		}
		if(mp3.hasID3v2Tag()){
			this.id = mp3.getID3v2Tag();
			return "id3v2";
		}
		return "-1";
	}
	
	public void setSongName(String targetName) throws IOException, TagException {
		this.id.setSongTitle(targetName);
		this.mp3.save();
		this.title = targetName;
	}
	
	public void setSongArtist(String targetName) throws IOException, TagException{
		this.id.setLeadArtist(targetName);
		this.mp3.save();
		this.artist = targetName;
	}

	private void setIdentifier(){
		String title = this.title.toLowerCase();
		String id = "";
		for(int i = 0; i < title.length(); i++){
			char letter = title.charAt(i);
			if(letter > 96 && letter < 123){
				id += letter;
			}
		}
		this.identifier = id;		
	}

	public String getIdentifier(){
		return this.identifier;
	}
}