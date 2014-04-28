import java.io.File;
import java.io.IOException;

public class songManager {
	public static void main(String [] args){
		if(args.length != 1){
			usage();
		}
		File f = new File(args[0]);
	}
	
	public static void usage(){
		System.out.println("one argument is required:" +
				"\n- File path containing songs");
		System.exit(1);
	}
}
