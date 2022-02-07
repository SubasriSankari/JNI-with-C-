
import java.io.*;

public class FilePermission{
	public static void main(String[] args){
		File file = new File("example1.txt");
		if(file.exists()){
			System.out.println("File has "+file.canWrite() +" Write permission.");
			boolean val = file.setWritable(true,true);
			System.out.println("File has "+file.canRead()  +" Read permission.");
			System.out.println(val);
		} else{
			System.out.println("File does not exist");
		}
	}
}

