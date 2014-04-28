import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class songManager {
	
	private File folder;
	private ArrayList<mp3> songs;
	
	public songManager(){
		this.folder = null;
	}
	
	public songManager(File f){
		if(fileExists(f)){
			System.out.println("file " + f.getAbsolutePath() + " does not exist");
			folder = null;
		}else{
			this.folder = f;
			try {
				buildList(this.folder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean fileExists(File f){
		return f.exists();
	}
	
	public void setMP3Folder(String dir){
		this.folder = new File("/", dir);
		System.out.println(this.folder.getAbsolutePath());
	}
	
	public static void main(String [] args){
		if(args.length != 1){
			usage();
		}
		
		File f = new File(args[0]);
		songManager songMan = new songManager(f);
	}
	
	public static void usage(){
		System.out.println("one argument is required:" +
				"\n- File path containing songs");
		System.exit(1);
	}

	private void buildList(File dir) throws Exception{
		this.songs = new ArrayList<mp3>();
		
		for (File file : dir.listFiles()){
			if (file.isDirectory()){
				System.out.println("DIR: " + file);
				buildList(file);	
			} else {
				//System.out.println("FIL: " + file);
				if(file.getName().contains(".mp3")){
					mp3 song = new mp3(file);
					System.out.println("added: " + file.getName());
					songs.add(song);
				}
			}

		}
	}

}
