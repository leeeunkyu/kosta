package com.kosta.excel_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelTest {

	public ExcelTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("20172.xlsx");
        XSSFWorkbook wb = null;
        
		try {//���� ���� ����
			wb = new XSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//���� ���� �ӽ� ����
        Vector<String> tmpContent = new Vector<String>();
        boolean isNull = false;
        
        for( Row row : wb.getSheetAt(0) ) {// �� ����
        	String str = new String();
            for( Cell cell : row ) { // ������
            	isNull = false;
                
            	// ���� Ÿ�� ���� �޾Ƽ� �������� �޵� �� ���� �ϳ��� ��Ʈ������ ����
                switch( cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING :
                        str = str + cell.getRichStringCellValue().getString();
                        break;

                    case Cell.CELL_TYPE_NUMERIC :
                        if(DateUtil.isCellDateFormatted(cell))
                        	str = str + cell.getDateCellValue().toString();
                        else
                            str = str + Integer.toString((int)cell.getNumericCellValue());
                        break;
                        
                    case Cell.CELL_TYPE_BOOLEAN :
                        str = str + cell.getBooleanCellValue();
                        break;

                    case Cell.CELL_TYPE_FORMULA :
                        str = str + cell.getCellFormula();
                        break;

                    default: // ���� ���� ���� ���Ե��� �ʰ� ��. 
                        isNull = true;
                }                
                if(isNull != true)
                	str = str + " ";
            }
            // �� ���� ���� ���� ���Ϳ� �߰�
            tmpContent.add(str);
            System.out.println(str);
        }

        Vector<String> Content = new Vector<String>();
        
        //�� �྿ �����鼭 ������ �迭�� space�� �߰��ǰ��� ���� ��Ŵ.
      //�̺κ��� space�� �������� ����մϴ�.
//        for(int i=0; i< tmpContent.size(); i++)
//		{	
//        	String str = tmpContent.get(i);
//        	str = str.substring(0, str.length()-1);
//        	Content.add(str);
//		}



	}

}
