import java.util.*;

public class PatternPrint{
	public native void pattern(int num);
	static{
		System.loadLibrary("Pattern");
	}	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to print pattern : ");
		int numOfTimes = sc.nextInt();
		PatternPrint times = new PatternPrint();
		times.pattern( numOfTimes );
	}
}