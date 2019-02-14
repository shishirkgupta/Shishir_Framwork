package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.CyclosApachePOIExcelNegativeRead;
import com.training.readexcel.CyclosReadExcel;
import com.training.readexcel.ReadExcel;
import com.training.bean.CyclosBean;
import com.training.dao.CyclosDAO;

public class CyclosDataProvidersExlNegative {
	
	
	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<CyclosBean> list = new CyclosDAO().getCyclos(); 

		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(CyclosBean temp : list){
			Object[]  obj = new Object[8]; 
			obj[0] = temp.getRecipient(); 
			obj[1] = temp.getAmount();
			obj[2] = temp.getDescription();
			result[count ++] = obj; 
		}

		return result;
	}

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData() {
		String fileName = "C:\\TestData\\TestDataNegative.xlsx";
		return new CyclosApachePOIExcelNegativeRead().getExcelContent(fileName);
	}

	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new CyclosReadExcel().getExcelData("C:\\TestData\\TestDataNegative.xlsx", "Sheet2");
	}

}
