package gugudan;
import java.io.IOException;

public class Gugudan_0801 {
	public int danInput() throws IOException {
		System.out.print("���ϴ� ��?");
		int num=System.in.read()-48;
		System.in.read();
		System.in.read();
		return num;
	}
	public void danOutput(int dan){
		System.out.println("["+dan+"��]");
		for(int i=1;i<10;i++)
			System.out.println(" "+dan+" * "+i+" = "+dan*i);
		
	}
	public char continue_dan() throws IOException {
		System.out.println("��� �Ͻðڽ��ϱ�? y/n");
		char respone=(char)System.in.read();
		System.in.read();
		System.in.read();
		return respone;
	}
}
