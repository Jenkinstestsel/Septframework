package dataProvider;

import generics.ExcelRW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;



public class basic_Dp_dataProvider {
	
@DataProvider(name="validlogin")
public static Iterator<Object[]> dp_validLogin() throws Exception{
	
	ExcelRW ex = new ExcelRW("C:\\Users\\DELL\\Desktop\\TestData.xlsx");
	String sheetName = "Login";
	int rowCount = ex.getRowCount(sheetName);
	int colCount= ex.getColCount(sheetName);
	
	List<Object[]> ls = new ArrayList<Object[]>();
	
//	read rows
	for(int iRow=1;iRow<=rowCount;iRow++){
//		validate the condition
		
		String Ascript = ex.readCellValue(sheetName, iRow, 3);
		String flag = ex.readCellValue(sheetName, iRow, 2);
		
		if(Ascript.toLowerCase().trim().equals("validlogin") && flag.toLowerCase().trim().equals("y")){
//		create Map
		Map<String, String> hm = new HashMap<String ,String>();
//		create Object Array
		Object[] x = new Object[1];			
		
//		for columns
		for(int iCol=0;iCol<colCount;iCol++){
	
				String Key = ex.readCellValue(sheetName, 0, iCol);
				String Val = ex.readCellValue(sheetName, iRow, iCol);
				hm.put(Key, Val);
	
	
		}	 //Col
		
		x[0] = hm;
		ls.add(x);
		} //validate condition
		
	} //Row
	
return	ls.iterator();
	
	
	
}
	
	
@DataProvider(name="invalidlogin")
public static Iterator<Object[]> dp_invalidLogin() throws Exception{
	
	ExcelRW ex = new ExcelRW("C:\\Users\\DELL\\Desktop\\TestData.xlsx");
	String sheetName = "Login";
	int rowCount = ex.getRowCount(sheetName);
	int colCount= ex.getColCount(sheetName);
	
	List<Object[]> ls = new ArrayList<Object[]>();
	
//	read rows
	for(int iRow=1;iRow<=rowCount;iRow++){
//		validate the condition
		
		String Ascript = ex.readCellValue(sheetName, iRow, 3);
		String flag = ex.readCellValue(sheetName, iRow, 2);
		
		if(Ascript.toLowerCase().trim().equals("invalidlogin") && flag.toLowerCase().trim().equals("y")){
//		create Map
		Map<String, String> hm = new HashMap<String ,String>();
//		create Object Array
		Object[] x = new Object[1];			
		
//		for columns
		for(int iCol=0;iCol<colCount;iCol++){
	
				String Key = ex.readCellValue(sheetName, 0, iCol);
				String Val = ex.readCellValue(sheetName, iRow, iCol);
				hm.put(Key, Val);
	
	
		}	 //Col
		
		x[0] = hm;
		ls.add(x);
		} //validate condition
		
	} //Row
	
return	ls.iterator();
	
}
	
	
	
@DataProvider(name="invalidsearch")
public static Iterator<Object[]> dp_invalidSearch() throws Exception{
	
	ExcelRW ex = new ExcelRW("C:\\Users\\DELL\\Desktop\\TestData.xlsx");
	String sheetName = "Search";
	int rowCount = ex.getRowCount(sheetName);
	int colCount= ex.getColCount(sheetName);
	
	List<Object[]> ls = new ArrayList<Object[]>();
	
//	read rows
	for(int iRow=1;iRow<=rowCount;iRow++){
//		validate the condition
		
		String Ascript = ex.readCellValue(sheetName, iRow, 3);
		String flag = ex.readCellValue(sheetName, iRow, 2);
		
		if(Ascript.toLowerCase().trim().equals("invalidsearch") && flag.toLowerCase().trim().equals("y")){
//		create Map
		Map<String, String> hm = new HashMap<String ,String>();
//		create Object Array
		Object[] x = new Object[1];			
		
//		for columns
		for(int iCol=0;iCol<colCount;iCol++){
	
				String Key = ex.readCellValue(sheetName, 0, iCol);
				String Val = ex.readCellValue(sheetName, iRow, iCol);
				hm.put(Key, Val);
	
	
		}	 //Col
		
		x[0] = hm;
		ls.add(x);
		} //validate condition
		
	} //Row
	
return	ls.iterator();
	
}
	
	
@DataProvider(name="validsearch")
public static Iterator<Object[]> dp_validSearch() throws Exception{
	
	ExcelRW ex = new ExcelRW("C:\\Users\\DELL\\Desktop\\TestData.xlsx");
	String sheetName = "Search";
	int rowCount = ex.getRowCount(sheetName);
	int colCount= ex.getColCount(sheetName);
	
	List<Object[]> ls = new ArrayList<Object[]>();
	
//	read rows
	for(int iRow=1;iRow<=rowCount;iRow++){
//		validate the condition
		
		String Ascript = ex.readCellValue(sheetName, iRow, 3);
		String flag = ex.readCellValue(sheetName, iRow, 2);
		
		if(Ascript.toLowerCase().trim().equals("validsearch") && flag.toLowerCase().trim().equals("y")){
//		create Map
		Map<String, String> hm = new HashMap<String ,String>();
//		create Object Array
		Object[] x = new Object[1];			
		
//		for columns
		for(int iCol=0;iCol<colCount;iCol++){
	
				String Key = ex.readCellValue(sheetName, 0, iCol);
				String Val = ex.readCellValue(sheetName, iRow, iCol);
				hm.put(Key, Val);
	
	
		}	 //Col
		
		x[0] = hm;
		ls.add(x);
		} //validate condition
		
	} //Row
	
return	ls.iterator();
	
}
	
	
	
	
	
	
	

}
