package com.kosta.excel_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelTest {
	 //if(columnindex==3 && rowindex>7) {
	public ExcelTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		XSSFWorkbook workbook;
		try {
			FileInputStream fis=new FileInputStream("20172.xlsx");
			workbook = new XSSFWorkbook(fis);
		String a_value="";//���
		String d_value="";//����
		String c_value="";//�÷���
		String t_value="";//������Ÿ��
		String b_value="";//�Ӽ�
		int rowindex=0;
		int columnindex=0;
		//��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		//���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		XSSFSheet sheet=workbook.getSheetAt(0);
		//���� ��
		int rows=sheet.getPhysicalNumberOfRows();
		for(rowindex=1;rowindex<rows;rowindex++){
		    //�����д´�
		    XSSFRow row=sheet.getRow(rowindex);
		    if(row !=null){
		        //���� ��
		        int cells=row.getPhysicalNumberOfCells();
		        for(columnindex=0;columnindex<=cells;columnindex++){
		            //������ �д´�
		            XSSFCell cell=row.getCell(columnindex);
		            String value="";
		            //���� ���ϰ�츦 ���� ��üũ
		           
			            if(cell==null){
			                continue;
			            }else{
			                //Ÿ�Ժ��� ���� �б�
			                switch (cell.getCellType()){
			                case XSSFCell.CELL_TYPE_FORMULA:
			                    value=cell.getCellFormula();
			                    break;
			                case XSSFCell.CELL_TYPE_NUMERIC:
			                    value=cell.getNumericCellValue()+"";
			                    break;
			                case XSSFCell.CELL_TYPE_STRING:
			                    value=cell.getStringCellValue()+"";
			                    break;
			                case XSSFCell.CELL_TYPE_BLANK:
			                    value=cell.getBooleanCellValue()+"";
			                    break;
			                case XSSFCell.CELL_TYPE_ERROR:
			                    value=cell.getErrorCellValue()+"";
			                    break;
			                }
			            }
			           System.out.println("��� :"+value);
		            

		        }
		    }
		}
		System.out.println(rowindex+"��"+columnindex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	}
