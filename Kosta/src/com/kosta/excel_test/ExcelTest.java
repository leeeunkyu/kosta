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
        
		try {//엑셀 파일 오픈
			wb = new XSSFWorkbook(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//라인 저장 임시 벡터
        Vector<String> tmpContent = new Vector<String>();
        boolean isNull = false;
        
        for( Row row : wb.getSheetAt(0) ) {// 행 구분
        	String str = new String();
            for( Cell cell : row ) { // 열구분
            	isNull = false;
                
            	// 셀의 타입 따라 받아서 구분지어 받되 한 행을 하나의 스트링으로 저장
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

                    default: // 값이 없는 열은 포함되지 않게 함. 
                        isNull = true;
                }                
                if(isNull != true)
                	str = str + " ";
            }
            // 한 행이 읽혀 지면 벡터에 추가
            tmpContent.add(str);
            System.out.println(str);
        }

        Vector<String> Content = new Vector<String>();
        
        //한 행씩 넣으면서 마지막 배열에 space가 추가되것을 제거 시킴.
      //이부분은 space가 있을때만 사용합니다.
//        for(int i=0; i< tmpContent.size(); i++)
//		{	
//        	String str = tmpContent.get(i);
//        	str = str.substring(0, str.length()-1);
//        	Content.add(str);
//		}



	}

}
