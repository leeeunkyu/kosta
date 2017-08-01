package gugudan;
import java.io.IOException;

public class Gugudan_0801 {
	public int danInput() throws IOException {
		System.out.print("원하는 단?");
		int num=System.in.read()-48;
		System.in.read();
		System.in.read();
		return num;
	}
	public void danOutput(int dan){
		System.out.println("["+dan+"단]");
		for(int i=1;i<10;i++)
			System.out.println(" "+dan+" * "+i+" = "+dan*i);
		
	}
	public char continue_dan() throws IOException {
		System.out.println("계속 하시겠습니까? y/n");
		char respone=(char)System.in.read();
		System.in.read();
		System.in.read();
		return respone;
	}
}
