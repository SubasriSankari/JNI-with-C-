public class PrintSum{
	public native void sumOfTwoNum(int num1, int num2);
	static{
		System.loadLibrary("SumOfTwoNum");
	}
	public static void main(String[] args){
		PrintSum sum = new PrintSum();
		sum.sumOfTwoNum( 10 , 20 );
	}
}