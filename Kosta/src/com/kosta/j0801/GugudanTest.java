package gugudan;
import java.io.IOException;

class GugudanTest
{
	public static void main(String[] args) throws IOException 
	{
		int dan=0;
		//boolean con_dan=true;
		char result='y';
		Gugudan gt= new Gugudan();
		while(true){
			if(result != 'N' && result != 'n' && result != 'y' && result != 'Y'){
				System.out.println("�߸��� �����Դϴ�.");
				result=gt.continue_dan();
				continue;
			}else{
				if(result == 'N' || result =='n'){
				System.out.println("�۾��� ��ġ�ڽ��ϴ�.");				
				break;
				}		
			}
			dan=gt.danInput();
			gt.danOutput(dan);
			result=gt.continue_dan();
		}
		
	}
}

	