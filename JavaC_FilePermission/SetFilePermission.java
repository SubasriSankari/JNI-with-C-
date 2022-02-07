import java.io.*;

public class SetFilePermission{
	public native String cFileCall(String filename);
	
	static{
		System.loadLibrary("CFileCall");
	}
	public static void main(String[] args){
		SetFilePermission obj = new SetFilePermission();
		File file = new File("hello.c");
		if(file.exists()){
			boolean result = file.setReadable(true,false);
			obj.cFileCall("hello.c");	
		}
		else
		{
			System.out.println("Sorry...File doesn't exists");
		}
		
		
	}
}