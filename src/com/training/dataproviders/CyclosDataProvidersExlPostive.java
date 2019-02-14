package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.CyclosApachePOIExcelNegativeRead;
import com.training.readexcel.CyclosApachePOIExcelPositiveRead;
import com.training.readexcel.ReadExcel;

public class CyclosDataProvidersExlPostive {

	@DataProvider(name = "db-inputs")
	public Object[][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins();

		Object[][] result = new Object[list.size()][];
		int count = 0;
		for (LoginBean temp : list) {
			Object[] obj = new Object[2];
			obj[0] = temp.getUserName();
			obj[1] = temp.getPassword();

			result[count++] = obj;
		}

		return result;
	}

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData() {
		String fileName = "C:\\TestData\\TestData.xlsx";
		return new CyclosApachePOIExcelPositiveRead().getExcelContent(fileName);
	}

	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData() {
		// ensure you will have the title as first line in the file
		return new ReadExcel().getExcelData("C:\\TestData\\TestData.xlsx", "Sheet2");
	}
}
