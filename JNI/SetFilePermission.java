import java.io.*;

public class SetFilePermission{
	public native String cFileCall(String filename);
	
	static{
		System.loadLibrary("CFileCall");
	}
	public static void main(String[] args){
		SetFilePermission obj = new SetFilePermission();
		File file = new File("C:\\Program Files\\JNI_Java_C\\JNI\\hello");
		file.mkdir();
		obj.cFileCall("hello.c");
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		if(file.exists()){
			System.out.println("Before setting EXECUTION "+file.canExecute());
			boolean result = file.setWritable(false);
			System.out.println("After setting EXECUTION "+file.canExecute());
			System.out.println("setExecution "+result+"\n");
			System.out.println("After");
			obj.cFileCall("hello.c");				
		}
		else
		{
			System.out.println("Sorry...File doesn't exists");
		}
		
	}
}