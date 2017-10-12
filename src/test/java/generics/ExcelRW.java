package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	FileInputStream fis;
	XSSFWorkbook wb;
	
//	initilize workbook
	public ExcelRW(String path) throws Exception{
//		create file input stream
		 fis= new FileInputStream(path);
//		Create workbook
		wb = new XSSFWorkbook(fis);		
		
	}
	
	
	
//	initilize workbook
	public void intilizeWorkbook(String path) throws Exception{
//		create file input stream
		 fis= new FileInputStream(path);
//		Create workbook
		wb = new XSSFWorkbook(fis);		
		
	}
	
//	getSheet
	public  XSSFSheet getSheet(String SheetName){
			return wb.getSheet(SheetName);		
	}
//	getRowCount
	public int getRowCount(String sheetName){
				int rowcount = getSheet(sheetName).getLastRowNum();		
		return rowcount;
	}
//	getColCount
	public int getColCount(String sheetName){
		
		int colcount = getSheet(sheetName).getRow(0).getLastCellNum();		
		return colcount;
	}
//	ReadCell
	public String readCellValue(String sheetName,int row,int column){
	
		XSSFCell datacell = getSheet(sheetName).getRow(row).getCell(column);
		String CellVal = null;
		
		if(datacell.getCellType() == Cell.CELL_TYPE_STRING){
			
			CellVal=datacell.getStringCellValue();
			
		}else if(datacell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			
			CellVal=String.valueOf(datacell.getNumericCellValue());
			
		}else if(datacell.getCellType() == Cell.CELL_TYPE_BLANK){
		
			CellVal="";
		}
		
		return CellVal;
		
	}
	
//	WriteCell
	public void writeCellValue(String sheetName,int row,int column,String val){
		

		getSheet(sheetName).getRow(row).getCell(column).setCellValue(val);
		
	}
	
	
	
//	SaveandClose	
	public void saveAndClose(String path) throws Exception{
//		Create file output stream
		FileOutputStream fos = new FileOutputStream(path);
//		Save Workbook
		wb.write(fos);
//		Close streams		
		fis.close();
		fos.close();	
	}

}
