package com.kosta.j0808;


class D{
   int i=11;
}
class E extends D{
	int j=22;
}
class F extends E{
	int k=33;
}

public class InstanceofTest {
   public static void main(String[] args) {
       //�������� instanceof Type	  ---> boolean
        D d = new D();
        E e = new E();
        F f = new F();
        
        if(d instanceof D) {
          System.out.println("d�� Ŭ����D�� ��ü");  	
        }
        
        if(d instanceof F) {
        	System.out.println("d�� Ŭ����F�� ��ü");  	
        }
        if(f instanceof D) {
        	System.out.println("f�� Ŭ����D�� ��ü");  	
        }
        
        int su=1;//4;//�ֹι�ȣ ���ڸ� ù��° ����(1~8)
        
        //�������ϱ�
        /*if(su%2==0) {"����"}
        else {"����"}*/
        //���׿����� ----> ���ǽ� ? A������ : B������;
        String gender = (su%2==0) ? "����" : "����";
        System.out.println("���� = "+ gender);
        
   }//main
}


