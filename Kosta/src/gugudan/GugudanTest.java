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
				System.out.println("잘못된 형식입니다.");
				result=gt.continue_dan();
				continue;
			}else{
				if(result == 'N' || result =='n'){
				System.out.println("작업을 마치겠습니다.");				
				break;
				}		
			}
			dan=gt.danInput();
			gt.danOutput(dan);
			result=gt.continue_dan();
		}
		
	}
}

	