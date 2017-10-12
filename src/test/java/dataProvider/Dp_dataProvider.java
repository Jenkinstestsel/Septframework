package dataProvider;

import generics.ExcelRW;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;



public class Dp_dataProvider {
	
@DataProvider(name="commondp")
public static Iterator<Object[]> dp_commonDP(Method m) throws Exception{

	
	String[] split = m.getName().split("_");
	String sheetName=split[0];
	String scriptName=split[1];
	
	
	return commondp_logic(sheetName,scriptName);
		
}
	
	
//	
//	
//@DataProvider(name="validlogin")
//public static Iterator<Object[]> dp_validLogin() throws Exception{
//	return commondp_logic("Login","validlogin");
//}
//	
//	
//@DataProvider(name="invalidlogin")
//public static Iterator<Object[]> dp_invalidLogin() throws Exception{
//	return commondp_logic("Login","invalidlogin");
//}
//	
//	
//@DataProvider(name="invalidsearch")
//public static Iterator<Object[]> dp_invalidSearch() throws Exception{
//	return commondp_logic("Search","invalidsearch");
//	
//}
//	
//	
//@DataProvider(name="validsearch")
//public static Iterator<Object[]> dp_validSearch() throws Exception{
//return commondp_logic("Search","validsearch");
//}
//	
//
//@DataProvider(name="addbook")
//public static Iterator<Object[]> dp_addBook() throws Exception{
//return commondp_logic("Cart","addbook");
//}
//
//
//



public static Iterator<Object[]> commondp_logic(String sheetName, String scriptName) throws Exception{
		
ExcelRW ex = new ExcelRW("C:\\Users\\DELL\\Desktop\\TestData.xlsx");

int rowCount = ex.getRowCount(sheetName);
int colCount= ex.getColCount(sheetName);

List<Object[]> ls = new ArrayList<Object[]>();

//read rows
for(int iRow=1;iRow<=rowCount;iRow++){
//	validate the condition
	
	String Ascript = ex.readCellValue(sheetName, iRow, 3);
	String flag = ex.readCellValue(sheetName, iRow, 2);
	
	if(Ascript.toLowerCase().trim().equals(scriptName.toLowerCase().trim()) && flag.toLowerCase().trim().equals("y")){
//	create Map
	Map<String, String> hm = new HashMap<String ,String>();
//	create Object Array
	Object[] x = new Object[1];			
	
//	for columns
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
